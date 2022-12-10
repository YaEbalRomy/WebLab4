package com.examle.web4.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProvider {

    //@Value("#{systemEnvironment['jwtSecret'] ?: 'jwtSecret'}")
    private final String secret = "g4gu31341h4ev1b";

    public String createToken(String username, long validityInMilSec) {

        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
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
    public String resolveAccessToken(HttpServletRequest req) {
        return req.getHeader("AccessToken");
    }
    public String resolveRefreshToken(HttpServletRequest req) {
        return req.getHeader("RefreshToken");
    }
}
