package com.ltadcrm.ltadcrm.gateway;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.InventoryItems;
import com.ltadcrm.ltadcrm.repositories.InventoryItemsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAllEntities {

    private final InventoryItemsRepository inventoryRepository;

    public ResponseEntity<String> deleteItem(List<Long> id) {

       List<InventoryItems> rows = inventoryRepository.findAllById(id);
        try {
            if (!rows.isEmpty()) {
                inventoryRepository.deleteAll(rows);
            }
            return ResponseEntity.ok("");  
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("null");
        }

    }
}
