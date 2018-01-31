package com.arsoft.projects.common.cryptography;

import static org.junit.Assert.assertNotNull;

import javax.crypto.SecretKey;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.arsoft.projects.common.exception.ArException;

public class ArCryptographyTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testGetKey() throws ArException{
		SecretKey key = ArCryptography.getKey(ArCryptographyConstant.ALGORITHM.DES);
		assertNotNull(key);
		key = ArCryptography.getKey(ArCryptographyConstant.ALGORITHM.AES);
		assertNotNull(key);
		key = ArCryptography.getKey(ArCryptographyConstant.ALGORITHM.RC2);
		assertNotNull(key);
		key = ArCryptography.getKey(ArCryptographyConstant.ALGORITHM.RC4);
		assertNotNull(key);
		key = ArCryptography.getKey(ArCryptographyConstant.ALGORITHM.BLOWFISH);
		assertNotNull(key);
	}
	
	@Test
	public void testGetKeyGenerateException() throws ArException{
		expectedEx.expect(ArException.class);
	    expectedEx.expectMessage("ArCyptrography: Not able to generate keyGenerator for algorithm: ANSHUL");
	    ArCryptography.getKey("ANSHUL");
	}
}
