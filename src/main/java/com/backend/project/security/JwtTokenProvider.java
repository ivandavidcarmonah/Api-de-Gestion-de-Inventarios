package com.backend.project.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.backend.project.exceptions.BackStandarAppException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpiration;
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expirationDate = new Date(currentDate.getTime() + jwtExpiration);
		
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, this.jwtSecret).compact();
		
		return token;
	}
	
	public String getUsernameOfJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			
			Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token);
			return true;
			
		} 
		catch (SignatureException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.FIRMA_NO_VALIDA");
		}
		catch (MalformedJwtException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.TOKEN_NO_VALIDO");
		}
		catch (ExpiredJwtException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.TOKEN_CADUCADO");
		}
		catch (UnsupportedJwtException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.TOKEN_NO_COMPATIBLE");
		}
		catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new BackStandarAppException(HttpStatus.BAD_REQUEST, "JWT.CADENA_CLAIMS_VACIA");
		}
	}
}
