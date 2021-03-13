package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Currency;
import za.co.discovery.application.entity.CurrencyConversionRate;
import za.co.discovery.application.repository.CurrencyConversionRateRepository;

@Component
@Transactional
public class CurrencyConverterImpl implements CurrencyConverter {
	
	@Autowired
	CurrencyConversionRateRepository  currencyConversionRateRepository;


	
	@Override
	public CurrencyConversionRate findByCurrency(String currencyCode){
		Currency currency = new Currency(currencyCode);
		currency.setCurrencyCode(currencyCode);
		return currencyConversionRateRepository.findByCurrency(currency);
     	}


	@Override
	public BigDecimal convert(String currencyCode, BigDecimal amount) {
		
		MathContext precision = new MathContext(4); // example 2
		amount.setScale(6);
		CurrencyConversionRate CurrencyConversionRate = findByCurrency(currencyCode);
		
		if (CurrencyConversionRate!=null && isBaseCurrency(CurrencyConversionRate)) {
		}
		return amount.divide(CurrencyConversionRate.getRate(),6, RoundingMode.HALF_DOWN);
	}

	private boolean isBaseCurrency(CurrencyConversionRate currencyConversionRate) {
		String currencyCode = currencyConversionRate.getCurrency().getCurrencyCode();
		return currencyCode.equals(BaseCurrencyCode.USD) || currencyCode.equals(BaseCurrencyCode.EUR)
				|| currencyCode.equals(BaseCurrencyCode.GBP);
	}

	

}
