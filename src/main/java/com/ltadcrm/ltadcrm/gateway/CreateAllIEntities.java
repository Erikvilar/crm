package com.ltadcrm.ltadcrm.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.DTO.domainDTO.UpdateDTO;
import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.CostCenter;

import com.ltadcrm.ltadcrm.domain.InventoryItems;
import com.ltadcrm.ltadcrm.domain.Users;
import com.ltadcrm.ltadcrm.repositories.ContactsRepository;
import com.ltadcrm.ltadcrm.repositories.CostCenterRepository;

import com.ltadcrm.ltadcrm.repositories.InventoryItemsRepository;
import com.ltadcrm.ltadcrm.repositories.UsersRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAllIEntities {

    

    private final InventoryItemsRepository inventoryRepository;
    private final UsersRepository usersRepository;
    private final CostCenterRepository costCenterRepository;
    private final ContactsRepository contactsRepository;

    public ResponseEntity<String> create(UpdateDTO updateDTO) {
        try {
 


            InventoryItems inventory = new InventoryItems();
     
            inventory.setCodePatrimony(updateDTO.getItemsDTO().getNumber());
            inventory.setEspecification(updateDTO.getItemsDTO().getObservation());
            inventory.setPathImage(updateDTO.getItemsDTO().getPathImage());
            inventory.setSde(updateDTO.getItemsDTO().getSde());
            inventory.setOrder(updateDTO.getItemsDTO().getOrder());
            inventory.setStatus(updateDTO.getItemsDTO().getStatus());
            inventory.setNfInvoice(updateDTO.getItemsDTO().getNfInvoice());
            inventory.setUnityValue(updateDTO.getItemsDTO().getValue());
            inventory.setUserLastupdate(updateDTO.getItemsDTO().getLastModification());
            inventory.setUpdateIn(updateDTO.getUpdateAt());

     
            Users user = new Users();
            user.setUserName(updateDTO.getUsersDTO().getUserName());
            user.setUserType(updateDTO.getUsersDTO().getUserType());
            user.setLastModification(updateDTO.getUsersDTO().getLastModification());


            CostCenter costCenter = new CostCenter();
            costCenter.setName(updateDTO.getCostCenterDTO().getName());
            costCenter.setIdentification(updateDTO.getCostCenterDTO().getIdentification());
            costCenter.setInitialDate(updateDTO.getCostCenterDTO().getInitialDate());
            costCenter.setEndDate(updateDTO.getCostCenterDTO().getEndDate());
            costCenter.setLastModification(updateDTO.getCostCenterDTO().getLastModification());

            Contacts contact = new Contacts();
            contact.setEmail(updateDTO.getContactsDTO().getEmail());
            contact.setOccupation(updateDTO.getContactsDTO().getOccupation());
            contact.setPhone(updateDTO.getContactsDTO().getPhone());
            contact.setLastModification(updateDTO.getContactsDTO().getLastModification());

            inventory.setUsers(user);
   
            inventory.setCostCenter(costCenter);

            usersRepository.save(user);

            costCenterRepository.save(costCenter);
            contactsRepository.save(contact);
            inventoryRepository.save(inventory);
         
            return ResponseEntity.ok("Item criado");
      

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ocorreu um erro ao criar o item "+e);
        }
    }

   

}
