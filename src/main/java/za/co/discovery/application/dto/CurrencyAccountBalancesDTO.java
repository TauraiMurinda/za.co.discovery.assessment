package za.co.discovery.application.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyAccountBalancesDTO {
		
	 private  String AccountNumber;
	 private String currency;
	 private Long currenceBalance;
	 private  BigDecimal ZarAmount;  

}
