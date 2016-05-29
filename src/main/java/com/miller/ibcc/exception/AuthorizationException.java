package com.miller.ibcc.exception;

public class AuthorizationException extends Exception {
	
	private static final long serialVersionUID = -5034639057858487280L;

	public AuthorizationException() {
		super();
	}

	public AuthorizationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AuthorizationException(String arg0) {
		super(arg0);
	}

	public AuthorizationException(Throwable arg0) {
		super(arg0);
	}

}
