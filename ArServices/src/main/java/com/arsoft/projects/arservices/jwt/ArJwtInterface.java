package com.arsoft.projects.arservices.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;

public interface ArJwtInterface {
	
	public String createJwtToken(String id, String issuer, String subject, long ttlMillis,
			SignatureAlgorithm signatureAlgorithm, final String secretKey);

	public boolean isValidJwtToken(String jwtToken, final String secretKey);
	
	public Jws<Claims> decodeJwtToken(String jwtToken, final String secretKey);
}
