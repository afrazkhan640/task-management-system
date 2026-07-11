package com.springbootTSM.task_management_system.security;

import java.security.Key;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtService {
	
	public static final String SECRET_KEY="thisIsMyVeryStrongSecretKeyForJwtAuthentication123";
	
	private Key getSignKey() {
		
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	public String generateToken(UserDetails userDetails) {
		
		return Jwts.builder()
				.subject(userDetails.getUsername())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+ 1000*60*60*24))
				.signWith(getSignKey())
				.compact();
	}
	private Claims extractAllClaims(String token) {
		
		return Jwts.parser()
				.verifyWith((javax.crypto.SecretKey)getSignKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	
	public String extractUsername(String token) {
		
		return extractAllClaims(token).getSubject();
	
	}
	
	public boolean isValidToken(String token,UserDetails userDetails) {
		
		String username=extractUsername(token);
		
		return username.equals(userDetails.getUsername())
				
				&& !extractAllClaims(token).getExpiration().before(new Date());
	}

	
}
