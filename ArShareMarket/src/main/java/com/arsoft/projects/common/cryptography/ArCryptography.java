package com.arsoft.projects.common.cryptography;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.arsoft.projects.common.exception.ArException;

public class ArCryptography {
	
	private static final Logger logger = Logger.getLogger(ArCryptography.class.getName());
	
	public static SecretKey getSecretKey(String algorithm) throws ArException{
		SecretKey secretKey = null;
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
			errorMessage = "ArCyptrography: Not able to generate keyGenerator for algorithm: "+algorithm +" : "+e.getMessage();
			logger.severe(errorMessage);
			throw new ArException(errorMessage);
		}
		secretKey = keyGenerator.generateKey();
		if (secretKey == null){
			throw new ArException("ArCyptrography: Not able to generate key for algorithm: "+algorithm);
		}
		return secretKey;
	}
	
	public static List<Provider> getAllSecurityProviders() throws ArException {
		Provider provider = null;
		List<Provider> providerList = null;
		try {
		      Provider p[] = Security.getProviders();
		      if (p.length > 0) {
		    	  providerList = new ArrayList<>();
		      }
		      for (int i = 0; i < p.length; i++) {
		          provider = p[i];
		          providerList.add(provider);
		      }
		    } catch (Exception e) {
		    	throw new ArException("ArCyptrography: Not able to get security providers: "+e.getMessage());
		    }
		return providerList;
	}
}
