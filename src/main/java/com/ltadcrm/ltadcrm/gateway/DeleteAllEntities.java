package com.ltadcrm.ltadcrm.gateway;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.repositories.ItemsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAllEntities {

    private final ItemsRepository itemsRepository;

    public ResponseEntity<String> deleteItem(List<Long> id) {

       List<Items> rows = itemsRepository.findAllById(id);
        try {
            if (!rows.isEmpty()) {
                itemsRepository.deleteAll(rows);
            }
            return ResponseEntity.ok("");  
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("null");
        }

    }
}
