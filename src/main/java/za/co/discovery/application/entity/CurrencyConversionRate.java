package za.co.discovery.application.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionRate implements java.io.Serializable {

	@Id
	private String currencyCode;
	private String conversionIndicator;
	private BigDecimal rate;

}
