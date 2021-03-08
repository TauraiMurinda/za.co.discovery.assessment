package za.co.discovery.application.exception;


/*The client does not have enough available funds
The system displays an error message “Insufficient funds”*/

public class NoEnoughFundsException extends Exception {
         public NoEnoughFundsException(String message,Throwable cause) {
        	 super(message,cause);
         }
         
         public NoEnoughFundsException(String message) {
        	 super(message);
         }
   }
