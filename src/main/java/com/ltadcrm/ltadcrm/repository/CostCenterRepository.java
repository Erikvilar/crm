package com.ltadcrm.ltadcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltadcrm.ltadcrm.domain.CostCenter;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long>{
    
}
