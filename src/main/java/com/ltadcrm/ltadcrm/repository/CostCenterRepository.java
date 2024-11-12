package com.ltadcrm.ltadcrm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltadcrm.ltadcrm.domain.CostCenter;


public interface CostCenterRepository extends JpaRepository<CostCenter, Long>{
    
    Optional<CostCenter> findAllById(Long id);
}
