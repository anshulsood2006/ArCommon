package com.arsoft.projects.common.cryptography;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.List;

import javax.crypto.SecretKey;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.arsoft.projects.common.exception.ArException;

public class ArCryptographyTest {
	
	@Before
	public void run() {
		System.out.println("Here");
	}
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testgetSecretKey() throws ArException{
		SecretKey key = ArCryptography.getSecretKey(ArCryptographyConstant.ALGORITHM.DES);
		assertNotNull(key);
		key = ArCryptography.getSecretKey(ArCryptographyConstant.ALGORITHM.AES);
		assertNotNull(key);
		key = ArCryptography.getSecretKey(ArCryptographyConstant.ALGORITHM.RC2);
		assertNotNull(key);
		key = ArCryptography.getSecretKey(ArCryptographyConstant.ALGORITHM.RC4);
		assertNotNull(key);
		key = ArCryptography.getSecretKey(ArCryptographyConstant.ALGORITHM.BLOWFISH);
		assertNotNull(key);
		key = ArCryptography.getSecretKey(ArCryptographyConstant.ALGORITHM.HMAC_SHA1);
		assertNotNull(key);
	}
	
	@Test
	public void testgetSecretKeyOne() throws ArException{
		List<Provider> providers = ArCryptography.getAllSecurityProviders();
		System.out.println(providers.size());
		System.out.println(providers);
	}
	
	
	@Test
	public void testGetAllSecurityProviders() throws ArException, NoSuchAlgorithmException, NoSuchProviderException {
		List<Provider> providers = ArCryptography.getAllSecurityProviders();
		assertEquals(providers.size(), 10);
		System.out.println(providers);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		providers = ArCryptography.getAllSecurityProviders();
		assertEquals(providers.size(), 11);
		System.out.println(providers);
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Signature signature = Signature.getInstance("SHA256withRSA", "BC");
		assertNotNull(signature);
	}
	
	@Test
	public void testgetSecretKeyGenerateException() throws ArException{
		expectedEx.expect(ArException.class);
	    expectedEx.expectMessage("ArCyptrography: Not able to generate keyGenerator for algorithm: ANSHUL");
	    ArCryptography.getSecretKey("ANSHUL");
	}
}
