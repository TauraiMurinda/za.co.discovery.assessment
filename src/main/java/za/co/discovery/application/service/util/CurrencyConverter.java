package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.util.Optional;

import za.co.discovery.application.entity.Currency;
import za.co.discovery.application.entity.CurrencyConversionRate;



@FunctionalInterface
public interface CurrencyConverter {
   default Optional<Currency> findById(String id){
	return null;
	}
   
 Float convert(String code, BigDecimal bigDecimal);

default CurrencyConversionRate findByCurrency(String currencyCode) {
		return null;
}	


}
