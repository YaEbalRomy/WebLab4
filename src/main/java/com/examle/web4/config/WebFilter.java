package com.examle.web4.config;

import com.examle.web4.jwt.JwtAuthException;
import com.examle.web4.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Filter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class WebFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String accessToken = jwtTokenProvider.resolveAccessToken(httpServletRequest);
        String refreshToken = jwtTokenProvider.resolveRefreshToken(httpServletRequest);
        try {
            if ((accessToken != null && jwtTokenProvider.validateAccessToken(accessToken)) || (refreshToken != null && jwtTokenProvider.validateRefreshToken(refreshToken))) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(jwtTokenProvider.getUsername(refreshToken),"", Collections.singleton((GrantedAuthority) () -> "USER"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JwtAuthException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}


