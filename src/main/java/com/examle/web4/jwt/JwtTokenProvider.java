package com.examle.web4.jwt;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String secret = "jwtSecret";
    public String createToken(String username) {

        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        long validityInMilSec = 900000;
        Date validity = new Date(now.getTime() + validityInMilSec);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) throws JwtAuthException {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException ex) {
            System.out.println("Jwt token не верный");
            return false;
        }
    }
    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("Authorization");
    }
}
