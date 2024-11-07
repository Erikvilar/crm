package com.ltadcrm.ltadcrm.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ltadcrm.ltadcrm.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
   UserDetails findByLogin(String login);
  
}
