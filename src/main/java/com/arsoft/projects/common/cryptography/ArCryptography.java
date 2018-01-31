package com.arsoft.projects.common.cryptography;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.arsoft.projects.common.exception.ArException;

public class ArCryptography {
	
	private static final Logger logger = Logger.getLogger(ArCryptography.class.getName());
	
	public static SecretKey getKey(String algorithm) throws ArException{
		SecretKey myDesKey = null;
		String errorMessage = null;
		KeyGenerator keyGenerator = null;
		try {
			keyGenerator = KeyGenerator.getInstance(algorithm);	
			if (keyGenerator == null){
				errorMessage = "ArCyptrography: Not able to generate keyGenerator for algorithm: "+algorithm;
				logger.severe(errorMessage);
				throw new ArException(errorMessage);
			}
		} catch (NoSuchAlgorithmException e) {
			errorMessage = "ArCyptrography: Not able to generate keyGenerator for algorithm: "+algorithm;
			logger.severe(errorMessage);
			throw new ArException(errorMessage);
		}
		myDesKey = keyGenerator.generateKey();
		if (myDesKey == null){
			throw new ArException("ArCyptrography: Not able to generate key for algorithm: "+algorithm);
		}
		return myDesKey;
	}
}
