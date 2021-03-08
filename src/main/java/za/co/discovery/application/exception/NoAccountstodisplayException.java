package za.co.discovery.application.exception;

public class NoAccountstodisplayException extends Exception{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAccountstodisplayException(String message,Throwable cause){
		  super(message,cause);
	}
   
   	public NoAccountstodisplayException(String message){
		  super(message);
	}
   	
	
}
