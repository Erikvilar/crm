package com.ltadcrm.ltadcrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltadcrm.ltadcrm.domain.logs.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long> {
  
}
