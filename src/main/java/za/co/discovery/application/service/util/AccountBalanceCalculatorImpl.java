package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Client;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.AccountBalance;



public class AccountBalanceCalculatorImpl  implements AccountBalanceCalculator {
	
	private AccountBalance accountBalance;
	private CurrencyConverter currencyConverter;

	AccountBalanceCalculatorImpl(AccountBalance accountBalance){
		       this.accountBalance = accountBalance;
	    }
	
	
    
	
	/*
	 * get All currency account and display
	 *  Client_account_number 
	 *  rates 
	 *  converted rands amounts
	 * currency accounts code
	 */
	
	@Override
	public List<ClientAccount> getClientAccounts(int clientId){
		return ((ClientAccountRepository) accountBalance).findByClientId(clientId);	
	}
	
	@Override
	public List<ClientAccount> getClientAccounts(int clientId,String  clientAccountNumber, String accountTypeCode){
		return ((ClientAccountRepository) accountBalance).findByClientIdAndClientAccountNumberAndAccountTypeCode(clientId,clientAccountNumber,accountTypeCode);	
	}
	
	
	@Override
	public List<ClientAccount> getClientAccounts(int clientId, String accountTypeCode){
		return ((ClientAccountRepository) accountBalance).findByClientIdAndAccountTypeCode(clientId,accountTypeCode);	
	}
	
	@Override
	public List<ClientAccount> getClientAccounts(String  clientAccountNumber, String accountTypeCode){
		return ((ClientAccountRepository) accountBalance).findByClientAccountNumberAndAccountTypeCode(clientAccountNumber,accountTypeCode);	
	}
	
	
	@Override
	public List<Result> getBalances(List<ClientAccount> Currencyccounts) {
			List<Result> results = Currencyccounts.stream().map(
				(ClientAccount ca) ->{
					     Result rs = new Result();
					        rs.setAccount_number(ca.getClientAccountNumber());
					        String currency_code =ca.getCurrencyCode();
					        rs.setCurrency(currency_code);
					        BigDecimal zar_amount = currency_code.equals("ZAR") ? BigDecimal.valueOf(ca.getDisplayBalance()) :currencyConverter.convert(ca.getCurrencyCode(), BigDecimal.valueOf(ca.getDisplayBalance()));
					        rs.setZar_amount(zar_amount);
					        return rs;
				}).collect(Collectors.toList());
		return results;		
	}

	
}

		