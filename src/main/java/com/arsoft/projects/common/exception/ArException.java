package com.arsoft.projects.common.exception;

import org.apache.logging.log4j.Logger;

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


}
