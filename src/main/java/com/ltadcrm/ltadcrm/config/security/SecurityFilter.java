package com.ltadcrm.ltadcrm.config.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ltadcrm.ltadcrm.repository.security.AccountRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private AccountRepository accountRepository;

  

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        System.out.println("TOKEN: " + token);
        if (token != null) {
            String login = tokenService.validateToken(token.trim());
            UserDetails account = accountRepository.findByLogin(login);
            System.out.println("CONTA: " + account);
            var authentication = new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        System.out.println("TOKEN NULO");
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ","");
    }
}
