package za.co.discovery.application.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements java.io.Serializable {

	@Id
	@GeneratedValue
	private int clientId;
	private String title;
	private String name;
	private String surname;
	private Date dob;
	private String clientSubTypeCode;

}
