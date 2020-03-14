package com.arsoft.projects.arservices.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ArJwt implements ArJwtInterface {

	@Override
	public String createJwtToken(String id, String issuer, String subject, long ttlMillis,
			SignatureAlgorithm signatureAlgorithm, final String secretKey) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);
		if (ttlMillis > 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	@Override
	public boolean isValidJwtToken(String jwtToken, final String secretKey) {
		try {
			Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(jwtToken);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Jws<Claims> decodeJwtToken(String jwtToken, final String secretKey) {
		if (!this.isValidJwtToken(jwtToken, secretKey)) {
			return null;
		}
		Jws<Claims> claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
				.parseClaimsJws(jwtToken);
		return claims;
	}

}
