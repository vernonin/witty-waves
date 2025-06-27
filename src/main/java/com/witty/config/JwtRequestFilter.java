package com.witty.config;

import com.witty.utils.JwtTokenUtil;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtRequestFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 获取请求中的 => "Authorization"
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        // 如果请求头带有token
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        }

        // 如果token合法
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 如果校验通过
            if (jwtTokenUtil.validateToken(jwtToken)) {
                UsernamePasswordAuthenticationToken upAuthToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                upAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(upAuthToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
