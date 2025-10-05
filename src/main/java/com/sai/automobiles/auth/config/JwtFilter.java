package com.sai.automobiles.auth.config;

import com.sai.automobiles.auth.service.CustomUserDetailsService;
import com.sai.automobiles.auth.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String authHeder = request.getHeader("Authorization");
       String token = null;
       String userName = null;

       if (Objects.nonNull(authHeder) && authHeder.startsWith("Bearer ")){
           token = authHeder.substring(7);
           userName = jwtService.getUserNameByToken(token);
       }

       if (Objects.nonNull(userName) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())){
          UserDetails userDetails = applicationContext.getBean(CustomUserDetailsService.class).loadUserByUsername(userName);

           if(jwtService.validateToken(token, userDetails)){
               UsernamePasswordAuthenticationToken authToken=
               new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
               authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authToken);
           }
       }
       filterChain.doFilter(request,response);
    }
}
