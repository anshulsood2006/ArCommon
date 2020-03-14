package com.arsoft.projects.arservices.jwt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtTest {
	
	@Test
	public void testJwtCreate() {
		ArJwt arJwt = new ArJwt();
		String jwtToken = arJwt.createJwtToken("id", "issuer", "subject", System.currentTimeMillis(), SignatureAlgorithm.HS256, "anshulsood");
		assertNotNull(jwtToken);
		boolean isValid = arJwt.isValidJwtToken(jwtToken, "anshulsood");
		assertTrue(isValid);
		isValid = arJwt.isValidJwtToken(jwtToken, "akhsood");
		assertFalse(isValid);
		Jws<Claims> claims = arJwt.decodeJwtToken(jwtToken, "anshulsood");
		assertEquals(claims.getBody().getId(), "id");
		claims = arJwt.decodeJwtToken(jwtToken, "akhilsood");
		assertNull(claims);
	}
}
