package com.ltadcrm.ltadcrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltadcrm.ltadcrm.domain.Contacts;


public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    
    Optional<Contacts> findAllById(Long id);
}
