package com.soda.web.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {
    private Key key;

    public JwtUtil() {
        String secret = "01234567890123456789012345678912";
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(String userId, String password) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("password", password)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
}
