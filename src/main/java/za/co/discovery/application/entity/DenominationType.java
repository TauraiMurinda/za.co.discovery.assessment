package za.co.discovery.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenominationType implements java.io.Serializable {

	@Id
	private String denominationTypeCode;
	private String description;

	
}
