package za.co.discovery.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency implements java.io.Serializable {

	
	public Currency(String currencyCode) {
		this.currencyCode=currencyCode;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	public String currencyCode;
	private int decimalPlaces;
	private String description;
	
	

}
