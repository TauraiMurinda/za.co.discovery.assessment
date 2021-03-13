package za.co.discovery.application.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRateCurrencyId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String currencyCode;
	//public int decimalPlaces;
	//public  String description;
	
	@Override
	  public boolean equals(Object object) {	
		String conversionRateCurrencyId = null;
		if (object!=null && object instanceof String )
	       conversionRateCurrencyId = (String)object;	
		return this.getCurrencyCode().equals(conversionRateCurrencyId);
	}
	
	
	@Override
	  public int hashCode() {
		return currencyCode.hashCode();	  
	  }

}
