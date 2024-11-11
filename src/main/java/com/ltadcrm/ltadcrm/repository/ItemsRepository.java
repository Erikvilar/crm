package com.ltadcrm.ltadcrm.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltadcrm.ltadcrm.domain.Items;


import jakarta.persistence.Tuple;
@Repository
public interface ItemsRepository extends CrudRepository<Items, Long> {
  

    @Query(value = "CALL GetAllItems()", nativeQuery = true)
    List<Tuple>findAllItemsDTOs();


}
