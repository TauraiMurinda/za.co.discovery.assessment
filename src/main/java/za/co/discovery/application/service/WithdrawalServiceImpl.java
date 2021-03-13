package za.co.discovery.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.exception.NoEnoughFundsException;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.util.AccountBalanceCalculator;
import za.co.discovery.application.service.util.ClientAccounts;

/*The client account balance has been adjusted with the withdrawal amount 
and the ATM has been notified of the number of notes per denomination to dispense*/
@Service
@Transactional(timeout = 4000)
public class WithdrawalServiceImpl implements WithdrawalService {
	
	@Autowired
	AccountBalanceCalculator  accountBalanceCalculator;
	@Autowired
	ClientAccounts clientAccounts;
	@Autowired
	ClientAccountRepository clientAccountRepository;
		
	@Override
	public Double    amountWithdrawing(String clientId ,double amount) throws NoEnoughFundsException{
		Client client = new  Client();
		client.setClientId(clientId);
		List<ClientAccount> transactionalAccounts = clientAccountRepository.findByClient(client);
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");

		System.out.println(transactionalAccounts);
		
//		
//		INSERT INTO ACCOUNT_TYPE VALUES ('CHQ', 'Cheque Account', 1);
//		INSERT INTO ACCOUNT_TYPE VALUES ('SVGS', 'Savings Account', 1);
//		INSERT INTO ACCOUNT_TYPE VALUES ('PLOAN', 'Personal Loan Account', 0);
//		INSERT INTO ACCOUNT_TYPE VALUES ('HLOAN', 'Home Loan Account', 0);
//		INSERT INTO ACCOUNT_TYPE VALUES ('CCRD', 'Credit Card', 1);
//		INSERT INTO ACCOUNT_TYPE VALUES ('CFCA', 'Customer Foreign Currency Account', 0);
		
		List<TransactionalAccountBalancesDTO> transactionalAccount= accountBalanceCalculator.getTransactionalAccountsBalances(transactionalAccounts)
				                                             .stream().filter( (acc)-> "SVGS".equalsIgnoreCase(acc.getAccountType()))
				                                             .collect(Collectors.toList())
				                                             ;
		System.out.println("******************************      "+transactionalAccount);

		BigDecimal balanceAmount = transactionalAccount.get(0).getAccountBalance();
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(balanceAmount);

		String accountNumber  = accountBalanceCalculator.getTransactionalAccountsBalances(transactionalAccounts)
                .stream().filter( (acc)-> "SVGS".equalsIgnoreCase(acc.getAccountType()))
                .collect(Collectors.toList()).get(0).getAccountNumber();
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(accountNumber);

		
		if(balanceAmount.doubleValue() <amount){
			throw new NoEnoughFundsException("---");
		}
		
		double newBalance  = balanceAmount.doubleValue() - amount; 
		
		//persisting new balance
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();
	    Executors.newCachedThreadPool().submit(() -> {
	    	clientAccountRepository.saveBalance(client,accountNumber,newBalance);
	    	completableFuture.complete("done");   
	    });  
		return newBalance;		
	    }

}
