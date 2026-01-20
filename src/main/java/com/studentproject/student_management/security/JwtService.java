package com.studentproject.student_management.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private final String SECRET = "mySecretKey123456789012345678901234567890";
    private final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String studentId) {
        return Jwts.builder()
                .subject(studentId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)) // תקף ליום אחד
                .signWith(KEY)
                .compact();
    }

    public String extractStudentId(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
