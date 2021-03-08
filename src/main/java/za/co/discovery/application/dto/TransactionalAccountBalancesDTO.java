package za.co.discovery.application.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionalAccountBalancesDTO {
	 private  String AccountNumber;
	 private String AccountType;
	 private BigDecimal AccountBalance;
}
