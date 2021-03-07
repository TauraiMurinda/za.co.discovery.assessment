package za.co.discovery.application.service.util;

import java.math.BigDecimal;
import java.util.Optional;

import za.co.discovery.application.entity.Currency;



@FunctionalInterface
public interface CurrencyConverter {
   default Optional<Currency> findById(String id){
	return null;
	}
   
 BigDecimal convert(String code, BigDecimal bigDecimal);	


}
