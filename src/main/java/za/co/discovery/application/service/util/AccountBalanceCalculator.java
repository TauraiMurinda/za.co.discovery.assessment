package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.AccountBalance;

public class AccountBalanceCalculator {
	
	private AccountBalance accountBalance;
	private CurrencyConverter currencyConverter;

	AccountBalanceCalculator(AccountBalance accountBalance){
		       this.accountBalance = accountBalance;
	    }
	
	
	/*
	 * get All currency account and display
	 *  Client_account_number 
	 *  rates 
	 *  converted rands amounts
	 * currency accounts code
	 */
	
	public void getBalances(String clientAccountNumber, String accountTypeCode) {
		
		List<ClientAccount> Currencyccounts = ((ClientAccountRepository) accountBalance).findByClientAccountNumberAndAccountTypeCode(clientAccountNumber,accountTypeCode);
		
		//method local inner class 
		class Result{
			 private  String account_number;
			 private String currency;
			 private Long currenceBalance;
			 private  BigDecimal zar_amount;
		   }
		  
		
		List<Result> results = Currencyccounts.stream().map(
				(ClientAccount ca) ->{
					     Result rs = new Result();
					        rs.account_number = ca.getClientAccountNumber();
					        String currency_code = rs.currency = ca.getCurrencyCode();
					        rs.currenceBalance= ca.getDisplayBalance();
					        rs.zar_amount = currency_code.equals("ZAR") ? BigDecimal.valueOf(ca.getDisplayBalance()) :currencyConverter.convert(ca.getCurrencyCode(), BigDecimal.valueOf(ca.getDisplayBalance()));
					return rs;
				}).collect(Collectors.toList());
		
					
	}	
	
}

		