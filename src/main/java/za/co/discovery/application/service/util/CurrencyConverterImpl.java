package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.application.entity.Currency;
import za.co.discovery.application.repository.CurrencyRepository;

@Component
@Transactional
public class CurrencyConverterImpl implements CurrencyConverter {

	private static final int Currency_conversion_rate = 0;

	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public Optional<Currency> findById(String code) {
		return currencyRepository.findById(code);
	}

	@Override
	public BigDecimal convert(String code, BigDecimal amount) {
		Optional<Currency> optionalCurrency = findById(code);
		if (optionalCurrency.isPresent() && isBaseCurrency(optionalCurrency)) {
			return amount.multiply(new BigDecimal(Currency_conversion_rate));
		}
		return amount.divide(new BigDecimal(Currency_conversion_rate));
	}

	private boolean isBaseCurrency(Optional<Currency> optionalCurrency) {
		String code = optionalCurrency.get().getDescription();
		return code.equals(BaseCurrencyCode.USD) || code.equals(BaseCurrencyCode.EUR)
				|| code.equals(BaseCurrencyCode.GBP);
	}

	

}
