package com.it.elec.exception;

public class LogonException extends Exception{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -8830252345228085618L;

	private String message;
	
	public LogonException(){}
	
	public LogonException(String message){
		super(message);
		this.setMessage(message);
		 
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
