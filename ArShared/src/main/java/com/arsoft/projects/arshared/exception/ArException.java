package com.arsoft.projects.arshared.exception;

import org.apache.logging.log4j.Logger;

import com.arsoft.projects.arshared.webservice.rest.error.ArError;


public class ArException extends Exception{

	private static final long serialVersionUID = 3548206157188383126L;
	
	public ArException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public ArException(Throwable throwable)
	{
		super(throwable);
	}
	
	public ArException(String exceptionMessage, Throwable throwable)
	{
		super(exceptionMessage, throwable);
	}

	public ArException(String exceptionMessage, Logger logger) {
		super(exceptionMessage);
		logger.error(exceptionMessage);
	}

	public static ArError createArError(String errorCode, String errorDescription){
		ArError arError = new ArError();
		arError.setErrorCode(errorCode);
		arError.setErrorDescription(errorDescription);
		return arError;
	}

}
