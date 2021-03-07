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
public class CreditCardLimit implements java.io.Serializable {
   
	@Id
	private int clientAccountNumber;
	private BigDecimal accountLimit;

	
}
