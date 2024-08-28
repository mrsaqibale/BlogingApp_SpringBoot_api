package com.blog.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

     private String fkey;
    public JwtService() {
         try {
         KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
         SecretKey sk = keyGen.generateKey();
         fkey = Base64.getEncoder().encodeToString(sk.getEncoded());
         } catch (Exception e) {
         throw new RuntimeException();
         }
        // fkey = "R{!D6,wY=i9vcjqMwR2P6JUNG8~v7r1cBI=?Z=uUg/!NN>&v?0j%}z,DQ6eEc&";

    }

    public String genrateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 10))
                .and()
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64
                .decode("thekeyvalidforthemanofthematchwhichisgoodforallthepersons");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
    	Claims clm;
    	clm = Jwts.parser()
    			.verifyWith((SecretKey) getKey())
    			.build()
    			.parseSignedClaims(token)
    			.getPayload();
    	return clm ;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
