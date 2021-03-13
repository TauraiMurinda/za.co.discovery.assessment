package za.co.discovery.application.exception;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

/*The client does not have enough available funds
The system displays an error message “Insufficient funds”*/

@Component
@NoArgsConstructor
public class NoEnoughFundsException extends Exception {
         /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public NoEnoughFundsException(String message,Throwable cause) {
        	 super(message,cause);
         }
         
         public NoEnoughFundsException(String message) {
        	 super(message);
         }
   }
