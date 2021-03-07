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
public class ClientSubType implements java.io.Serializable {
    
	@Id
	private String clientSubTypeCode;
	private String clientTypeCode;
	private String description;

}
