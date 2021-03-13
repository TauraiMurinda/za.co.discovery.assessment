package za.co.discovery.application.entity;
// Generated Mar 6, 2021, 3:37:31 PM by Hibernate Tools 5.4.27.Final

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientAccount implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	private String clientAccountNumber;
	@OneToOne(cascade = CascadeType.ALL) @JoinColumn(name ="clientId")
	private Client client;
	private String accountTypeCode;
	private String currencyCode;
	private Long displayBalance;

}
