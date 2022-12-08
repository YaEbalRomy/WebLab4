package com.examle.web4.config;

import com.examle.web4.jwt.JwtAuthException;
import com.examle.web4.jwt.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class WebFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    public WebFilter (JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtTokenProvider.resolveToken(httpServletRequest);
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(jwtTokenProvider.getUsername(token),"", Collections.singleton((GrantedAuthority) () -> "USER"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JwtAuthException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}


