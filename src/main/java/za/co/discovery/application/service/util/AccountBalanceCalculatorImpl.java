package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.service.CurrencyAccountBalances;



@Component
@Transactional
public class AccountBalanceCalculatorImpl  implements AccountBalanceCalculator {
	
	private CurrencyConverter currencyConverter;
   	
	/*
	 * get All currency account and display
	 *  Client_account_number 
	 *  rates 
	 *  converted rands amounts
	 * currency accounts code
	 */
		
	@Override
	public List<CurrencyAccountBalancesDTO> getCurrencyAccountsBalances(List<ClientAccount> currencyccounts) {
			List<CurrencyAccountBalancesDTO> currencyAccountBalancesDTO = currencyccounts.stream().map(
				(ClientAccount ca) ->{
					     CurrencyAccountBalancesDTO dto = new CurrencyAccountBalancesDTO();
					        dto.setAccountNumber(ca.getClientAccountNumber());
					        String currency_code =ca.getCurrencyCode();
					        dto.setCurrency(currency_code);
					        BigDecimal zar_amount = currency_code.equals("ZAR") ? BigDecimal.valueOf(ca.getDisplayBalance()) :currencyConverter.convert(ca.getCurrencyCode(), BigDecimal.valueOf(ca.getDisplayBalance()));
					        dto.setZarAmount(zar_amount);
					        return dto;
				}).collect(Collectors.toList());
		return currencyAccountBalancesDTO;		
	}
	
	
	@Override
	public List<TransactionalAccountBalancesDTO> getTransactionalAccountsBalances(List<ClientAccount> transactionalAccounts) {
			List<TransactionalAccountBalancesDTO> transactionalAccountBalancesDTO = transactionalAccounts.stream().map(
				(ClientAccount ca) ->{
					     TransactionalAccountBalancesDTO dto = new TransactionalAccountBalancesDTO();
					        dto.setAccountNumber(ca.getClientAccountNumber());
					        String currency_code =ca.getCurrencyCode();
					        BigDecimal zarAmount = currency_code.equals("ZAR") ? BigDecimal.valueOf(ca.getDisplayBalance()) :currencyConverter.convert(ca.getCurrencyCode(), BigDecimal.valueOf(ca.getDisplayBalance()));
					        dto.setAccountBalance(zarAmount);
					        return dto;
				}).collect(Collectors.toList());
		return transactionalAccountBalancesDTO;		
	}
	
	
	

	
}

		