package com.indecomm.customException;

public class IndecommSystemException extends Exception {

	 /**
	 * This class is a custom exception class 
	 * extends Exception
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;
	 
	    public IndecommSystemException() {
	        super();
	    }
	 
	    public IndecommSystemException(String message) {
	        super(message);
	        this.message = message;
	    }
	 
	    public IndecommSystemException(Throwable cause) {
	        super(cause);
	    }
	 
	    @Override
	    public String toString() {
	        return message;
	    }
	 
	    @Override
	    public String getMessage() {
	        return message;
	    }

}
