package za.co.discovery.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Denomination implements java.io.Serializable {

	@Id
	@GeneratedValue
	private int denominationId;
	private long value;
	
	@ManyToOne @JoinColumn(name = "DENOMINATION_TYPE_CODE")
	private DenominationType denominationType;

	
}
