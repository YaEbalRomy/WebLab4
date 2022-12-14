package com.examle.web4.jwt;

import com.examle.web4.entity.User;
import com.examle.web4.repository.UserRepository;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    //@Value("#{systemEnvironment['jwtSecret'] ?: 'jwtSecret'}")
    private final String secret = "g4gu31341h4ev1b";
    private final UserRepository userRepository;
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
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException ex) {
            return null;
        }
    }

    public boolean validateAccessToken(String token) throws JwtAuthException {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException ex) {
            System.out.println("Jwt accessToken не верный");
            return false;
        }
    }
    public boolean validateRefreshToken(String token) throws JwtAuthException, ExpiredJwtException {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            Optional<User> user = userRepository.getByUsername(getUsername(token));
            return user.filter(value -> (!claims.getBody().getExpiration().before(new Date())) && value.getRefreshToken().equals(token)).isPresent();
        } catch (JwtException | IllegalArgumentException | NullPointerException ex) {
            System.out.println("Jwt refreshToken не верный");
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
