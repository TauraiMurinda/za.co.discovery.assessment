package za.co.discovery.application.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(ConversionRateCurrencyId.class)
public class CurrencyConversionRate implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	//@EmbeddedId CurrencyConversionRateId currencyConversionRateId;
	
	@Id @Column(name = "CURRENCY_CODE")
	private String currencyCode;
	//public int decimalPlaces;
	
	//@Id
	//public String description;
	
	
    @OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name="CURRENCY_CODE")
    @MapsId
	public Currency currency;
	
	
	
	private String conversionIndicator;
	private BigDecimal rate;
	
	
	  @Override public boolean equals(Object object) { ConversionRateCurrencyId
	  conversionRateCurrencyId = null; if (object!=null && object instanceof
	  ConversionRateCurrencyId ) conversionRateCurrencyId =
	  (ConversionRateCurrencyId)object; return
	  this.getCurrencyCode().equals(conversionRateCurrencyId.getCurrencyCode()); }
	 
//	@Override
//	  public boolean equals(Object object) {	
//		String conversionRateCurrencyId = null;
//		if (object!=null && object instanceof String )
//	       conversionRateCurrencyId = (String)object;	
//		return this.getCurrencyCode().equals(conversionRateCurrencyId);
//	}
	
	
	@Override
	  public int hashCode() {
		return currencyCode.hashCode();	  
	  }

}
