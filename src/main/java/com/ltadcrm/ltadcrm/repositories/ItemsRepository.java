package com.ltadcrm.ltadcrm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltadcrm.ltadcrm.domain.Items;


import jakarta.persistence.Tuple;
@Repository
public interface ItemsRepository extends CrudRepository<Items, Long> {
  

    @Query(value = "CALL GetAllItems()", nativeQuery = true)
    List<Tuple>findAllItemsDTOs();

    Optional<Items> findAllById(Long id);
    

}
