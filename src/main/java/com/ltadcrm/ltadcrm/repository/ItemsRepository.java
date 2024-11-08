package com.ltadcrm.ltadcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ltadcrm.ltadcrm.domain.Items;
@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
  
    @Query(value = "CALL GetAllItems()", nativeQuery = true)
    List<Items> findAllItems();

}
