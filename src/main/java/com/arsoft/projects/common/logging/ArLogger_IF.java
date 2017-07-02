package com.arsoft.projects.common.logging;

public interface ArLogger_IF {
	
	public void logInfo(String message);
	public void logDebug(String message);
	public void logError(String message);
	public void logTrace(String message);
	public void logWarn(String message);
	public void logFatal(String message);
	
}
