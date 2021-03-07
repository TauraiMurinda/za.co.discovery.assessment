package za.co.discovery.application.service.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
			 private  String account_number;
			 private String currency;
			 private Long currenceBalance;
			 private  BigDecimal zar_amount;   

}
