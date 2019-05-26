package com.arsoft.projects.arshared.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ArConsoleLogger{

	private static final Logger logger;
	
	static {
		logger = Logger.getLogger(ArConsoleLogger.class.getName());
		logger.setUseParentHandlers(false);
		logger.addHandler(new ConsoleHandler(){
						
            @Override
            public synchronized void setFormatter(Formatter newFormatter){
                super.setFormatter(new Formatter()
                {
                    @Override
                    public String format(LogRecord record)
                    {
                        return record.getMessage() + "\n";
                    }
                });
            }
        });
	}
	
	public static void log(String logMessage) {
		logger.log(Level.SEVERE, logMessage);
	}
}
