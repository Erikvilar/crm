package com.ltadcrm.ltadcrm.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.repository.security.AccountRepository;

@Service
public class AuthorizationService implements UserDetailsService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return this.accountRepository.findByLogin(username);
    }
    
}
