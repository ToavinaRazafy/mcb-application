/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.user.util;


import com.microservice.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenUtil {
    @Value("${secret.key}")
    private String secretKey;
    @Value("${token.validity}")
    private static long tokenValidity;
  
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); 

    public static String generate(String subject) {
        // Set expiration time for the token (e.g., 1 hour)
        long expirationTimeMillis = 3600000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeMillis);

        // Generate the JWT token
        String jwtToken = Jwts.builder()
                .setSubject(subject)
                .setIssuer("example.com")
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();

        return jwtToken;
    }
    
    public  String generate(User login) {
        System.out.println("**************************" + login.getUsername());
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + tokenValidity);

        System.out.println("secret key : " + this.secretKey);
        
        return Jwts.builder()
                .setSubject("user information")
                .claim("role", login.getRole())
                .claim("id", login.getId())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    
    /*public static Jws<Claims> validateToken(String token) 
    {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes()) 
                .build()
                .parseClaimsJws(token);
        return claims ; 
    } */
    

}
