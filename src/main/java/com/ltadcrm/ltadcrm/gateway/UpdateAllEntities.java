package com.ltadcrm.ltadcrm.gateway;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltadcrm.ltadcrm.DTO.domainDTO.UpdateDTO;
import com.ltadcrm.ltadcrm.domain.InventoryItems;
import com.ltadcrm.ltadcrm.events.Items.ItemUpdatedEvent;
import com.ltadcrm.ltadcrm.gateway.mapper.ContactsMapper;
import com.ltadcrm.ltadcrm.gateway.mapper.CostCenterMapper;

import com.ltadcrm.ltadcrm.gateway.mapper.InventoryItemsMapper;

import com.ltadcrm.ltadcrm.gateway.mapper.UsersMapper;
import com.ltadcrm.ltadcrm.repositories.ContactsRepository;
import com.ltadcrm.ltadcrm.repositories.CostCenterRepository;
import com.ltadcrm.ltadcrm.repositories.DetailsRepository;
import com.ltadcrm.ltadcrm.repositories.InventoryItemsRepository;

import com.ltadcrm.ltadcrm.repositories.UsersRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateAllEntities {

        private final ContactsMapper contactsMapper;
        private final UsersMapper usersMapper;
        private final InventoryItemsMapper itemsMapper;
        private final CostCenterMapper costCenterMapper;

        private final InventoryItemsRepository inventoryRepository;
        private final ContactsRepository contactsRepository;
        private final CostCenterRepository costCenterRepository;

        private final UsersRepository usersRepository;

        private final ApplicationEventPublisher eventPublisher;


        @Transactional
        public ResponseEntity<String> update(UpdateDTO updateDTO) {
                try {

                        inventoryRepository.save(itemsMapper.updateDomainFromDTO(
                                        inventoryRepository.findById(updateDTO.getItemsDTO().getId()).get(),
                                        updateDTO.getItemsDTO()));
                        usersRepository.save(usersMapper.updateDomainFromDTO(
                                        usersRepository.findById(updateDTO.getContactsDTO().getId()).get(),
                                        updateDTO.getUsersDTO()));
               
                        contactsRepository.save(contactsMapper.updateDomainFromDTO(
                                        contactsRepository.findById(updateDTO.getContactsDTO().getId()).get(),
                                        updateDTO.getContactsDTO()));
                        costCenterRepository.save(costCenterMapper.updateDomainFromDTO(
                                        costCenterRepository.findById(updateDTO.getCostCenterDTO().getId()).get(),
                                        updateDTO.getCostCenterDTO()));
                        InventoryItems existingItem = inventoryRepository.findById(updateDTO.getItemsDTO().getId()).get();
                   
                        ItemUpdatedEvent event = new ItemUpdatedEvent(
                                        existingItem.getInventoryID(),
                                        existingItem.getUserLastupdate(),
                                        existingItem.getUnityValue()
                                      );
                        eventPublisher.publishEvent(event);

                        return ResponseEntity.ok("Dados salvos");
                } catch (Exception e) {
                        return ResponseEntity.badRequest().body("Error " + e);
                }
        }

   
}
