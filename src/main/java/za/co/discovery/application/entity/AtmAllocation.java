package za.co.discovery.application.entity;
// Generated Mar 6, 2021, 3:37:31 PM by Hibernate Tools 5.4.27.Final

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtmAllocation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int atmAllocationId;
	
	@ManyToOne @JoinColumn(name="ATM_ID")
	private Atm atm;
	
	@OneToOne @JoinColumn(name = "DENOMINATION_ID" )
	private Denomination denominationId;
	
	private int count;

}
