package za.co.discovery.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	AccountBalanceCalculator  accountBalanceCalculator;
	ClientAccounts clientAccounts;
	ClientAccountRepository clientAccountRepository;
		
	@Override
	public Double    amountWithdrawing(int clientId ,double amount) throws NoEnoughFundsException{
		List<ClientAccount> transactionalAccounts = clientAccounts.getClientAccounts(clientId);
		BigDecimal balanceAmount = accountBalanceCalculator.getTransactionalAccountsBalances(transactionalAccounts)
				                                             .stream().filter( (acc)-> "".equalsIgnoreCase(acc.getAccountType()))
				                                             .collect(Collectors.toList()).get(0).getAccountBalance();
		
		String accountNumber  = accountBalanceCalculator.getTransactionalAccountsBalances(transactionalAccounts)
                .stream().filter( (acc)-> "".equalsIgnoreCase(acc.getAccountType()))
                .collect(Collectors.toList()).get(0).getAccountNumber();
		
		if(balanceAmount.doubleValue() <amount){
			throw new NoEnoughFundsException("---");
		}
		
		double newBalance  = balanceAmount.doubleValue() - amount; 
		
		//persisting new balance
	    CompletableFuture<String> completableFuture = new CompletableFuture<>();
	    Executors.newCachedThreadPool().submit(() -> {
	    	clientAccountRepository.saveBalance(clientId,accountNumber,newBalance);
	    	completableFuture.complete("done");   
	    });  
		return newBalance;		
	    }

}
