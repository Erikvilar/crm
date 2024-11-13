package com.ltadcrm.ltadcrm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltadcrm.ltadcrm.domain.Descriptions;

public interface DescriptionsRepository extends JpaRepository<Descriptions, Long>{
    
    Optional<Descriptions> findAllById(Long id);
}
