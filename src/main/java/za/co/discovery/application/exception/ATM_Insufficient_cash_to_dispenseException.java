package za.co.discovery.application.exception;

/*The ATM does not have enough cash to dispense the required amount
The system displays an error message “Amount not available, would you like to draw X” where X is the next available amount lower than the requested amount.*/
public class ATM_Insufficient_cash_to_dispenseException extends RuntimeException {
	
	public ATM_Insufficient_cash_to_dispenseException(String message,Throwable cause) {
		  super(message,cause);
	 }
	
	public ATM_Insufficient_cash_to_dispenseException(String message) {
		  super(message);
	 }


}
