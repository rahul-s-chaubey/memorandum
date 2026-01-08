package com.idbi.memorandum.utility;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.idbi.memorandum.entities.EmpEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY =
            "memoSecretKey@2026memoSecretKey@2026memoSecretKey@2026";

    private static final long EXPIRATION_TIME = 60 * 60 * 1000; // 1 hour

    public String generateToken(EmpEntity emp) {

    	return Jwts.builder()
    	        .setSubject(emp.getEmail())

    	        // 🔹 BASIC
    	        .claim("ein", emp.getEin())
    	        .claim("role", emp.getRole())

    	        // 🔹 EMPLOYEE DETAILS
    	        .claim("fullNameTitle", emp.getFullNameTitle())
    	        .claim("grade", emp.getGrade())
    	        .claim("sol", emp.getSol())
    	        .claim("organization", emp.getOrganization())

    	        // 🔹 SUPERVISOR DETAILS
    	        .claim("supEin", emp.getSupEin())
    	        .claim("supFullNameTitle", emp.getSupFullNameTitle())
    	        .claim("supEmail", emp.getSupEmail())

    	        .setIssuedAt(new Date())
    	        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))

    	        .signWith(
    	                Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
    	                SignatureAlgorithm.HS256
    	        )
    	        .compact();

    }
}
