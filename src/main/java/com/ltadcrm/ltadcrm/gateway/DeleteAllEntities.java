package com.ltadcrm.ltadcrm.gateway;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.repositories.ItemsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAllEntities {

    private final ItemsRepository itemsRepository;

    public ResponseEntity<String> deleteItem(Long id) {

        Optional<Items> optionalItem = itemsRepository.findById(id);
        try {
            if (optionalItem.isPresent()) {
                itemsRepository.delete(optionalItem.get());
            }
            return ResponseEntity.ok("Linha " + optionalItem + " foi deletada");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocorreu um erro ao deletar " + e);
        }

    }
}
