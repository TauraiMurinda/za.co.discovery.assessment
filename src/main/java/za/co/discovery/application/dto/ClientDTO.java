package za.co.discovery.application.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	private String clientId;
	private String title;
	private String name;
	private String surname;
	private Date dob;
}
