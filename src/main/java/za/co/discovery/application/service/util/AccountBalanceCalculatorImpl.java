package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.dto.CurrencyAccountBalancesDTO;
import za.co.discovery.application.dto.TransactionalAccountBalancesDTO;
import za.co.discovery.application.entity.ClientAccount;
import za.co.discovery.application.entity.Currency;
import za.co.discovery.application.entity.CurrencyConversionRate;
import za.co.discovery.application.repository.ClientAccountRepository;
import za.co.discovery.application.repository.CurrencyConversionRateRepository;
import za.co.discovery.application.service.CurrencyAccountBalances;



@Component
@Transactional
public class AccountBalanceCalculatorImpl  implements AccountBalanceCalculator {
	
	@Autowired
	private CurrencyConverter currencyConverter;
   	
	/*
	 * get All currency account and display
	 *  Client_account_number 
	 *  rates 
	 *  converted rands amounts
	 * currency accounts code
	 */
		
	@Autowired
	CurrencyConversionRateRepository  currencyConversionRateRepository;
		
	@Override
	public List<CurrencyAccountBalancesDTO> getCurrencyAccountsBalances(List<ClientAccount> currencyccounts) throws Throwable {
		
		List<ClientAccount>  currencyAccountBalancesDTOfilter = currencyccounts.stream().filter(predicate -> !(predicate.getCurrencyCode().equals("ZAR"))).collect(Collectors.toList());
		
		List<CurrencyAccountBalancesDTO> currencyAccountBalancesDTO = currencyAccountBalancesDTOfilter.stream().map(
				(ClientAccount ca) ->{
					Currency currency = new Currency(ca.getCurrencyCode());
					CurrencyConversionRate CurrencyConversionRate = currencyConversionRateRepository.findByCurrency(currency);
					     CurrencyAccountBalancesDTO dto = new CurrencyAccountBalancesDTO();
					        dto.setAccountNumber(ca.getClientAccountNumber());
					        dto.setCurrency(ca.getCurrencyCode());
					        dto.setCurrenceBalance(ca.getDisplayBalance());
					        dto.setCurrencyConversionRate(CurrencyConversionRate.getRate());
					        					        
					        BigDecimal zar_amount =  currencyConverter.convert(ca.getCurrencyCode(), BigDecimal.valueOf(ca.getDisplayBalance()));
					        dto.setZarAmount(zar_amount);
					        return dto;
				}).collect(Collectors.toList());
		return currencyAccountBalancesDTO;		
	}
		
	@Override
	public List<TransactionalAccountBalancesDTO> getTransactionalAccountsBalances(List<ClientAccount> transactionalAccounts) {
		
		List<ClientAccount>  transactionalBalancesDTOfilter = transactionalAccounts.stream().filter(predicate -> predicate.getCurrencyCode().equals("ZAR")).collect(Collectors.toList());

			List<TransactionalAccountBalancesDTO> transactionalAccountBalancesDTO = transactionalBalancesDTOfilter.stream().map(
				(ClientAccount ca) ->{
					     TransactionalAccountBalancesDTO dto = new TransactionalAccountBalancesDTO();
					        dto.setAccountNumber(ca.getClientAccountNumber());
					        dto.setAccountType(ca.getAccountTypeCode());
					        String currency_code =ca.getCurrencyCode();
					        BigDecimal zarAmount =  BigDecimal.valueOf(ca.getDisplayBalance());
					        dto.setAccountBalance(zarAmount);
					        return dto;
				}).collect(Collectors.toList());
		return transactionalAccountBalancesDTO;		
	}
	
	
	

	
}

		