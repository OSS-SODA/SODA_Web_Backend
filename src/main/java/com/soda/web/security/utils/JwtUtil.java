package com.soda.web.security.utils;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.security.ClubMemberContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private final Key KEY;
    private static final String ISSUER = "SODA";

    public JwtUtil() {
        String secret = "01234567890123456789012345678912";
        KEY = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(ClubMemberContext context) {
        ClubMember clubMember = context.getClubMember();
        return Jwts.builder()
                .setIssuer(ISSUER)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .claim("USER_ID", clubMember.getMemberId())
                .claim("USER_ROLE", clubMember.getMemberPermission().getRole())
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public ClubMemberContext decodeJwt(String token) {
        Claims claims = getClaims(token);

        String userId = (String) claims.get("USER_ID");
        String role = (String) claims.get("USER_ROLE");
        // password 임의의 비밀번호 실제 password 아님
        return new ClubMemberContext(userId, "1234", role);
    }
}
