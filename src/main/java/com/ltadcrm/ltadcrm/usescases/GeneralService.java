package com.ltadcrm.ltadcrm.usescases;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.Account;
import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.CostCenter;
import com.ltadcrm.ltadcrm.domain.Descriptions;
import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.Users;
import com.ltadcrm.ltadcrm.domain.DTO.authentication.RegisterDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ContactsDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.CostCenterDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.DescriptionsDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemsDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UpdateDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UsersDTO;
import com.ltadcrm.ltadcrm.repositories.ContactsRepository;
import com.ltadcrm.ltadcrm.repositories.CostCenterRepository;
import com.ltadcrm.ltadcrm.repositories.DescriptionsRepository;
import com.ltadcrm.ltadcrm.repositories.ItemsRepository;
import com.ltadcrm.ltadcrm.repositories.UsersRepository;

import com.ltadcrm.ltadcrm.usescases.strategy.ItemDetailsDTOConvertImpl;

import jakarta.persistence.Tuple;

@Service
public class GeneralService {

    ItemsRepository itemsRepository;
    UsersRepository usersRepository;
    CostCenterRepository costCenterRepository;
    ContactsRepository contactsRepository;
    DescriptionsRepository descriptionsRepository;
    ItemDetailsDTOConvertImpl convert;

    public GeneralService(
            ItemsRepository itemsRepository,
            UsersRepository usersRepository,
            DescriptionsRepository descriptionsRepository,
            CostCenterRepository costCenterRepository,
            ContactsRepository contactsRepository,
            ItemDetailsDTOConvertImpl convert
          
            ) {
  
        this.itemsRepository = itemsRepository;
        this.usersRepository = usersRepository;
        this.descriptionsRepository = descriptionsRepository;
        this.costCenterRepository = costCenterRepository;
        this.contactsRepository = contactsRepository;
        this.convert = convert;

    }

    public List<ItemDetailDTO> listAll() throws Exception {
        try {
          
            List<ItemDetailDTO> dtos = new ArrayList<>();
            for (Tuple tuple :  itemsRepository.findAllItemsDTOs()) {
                ItemDetailDTO dto = convert.convert(tuple);
                dtos.add(dto);
            }
            return dtos;
        } catch (Exception e) {
            throw new Exception("Current error in ItemService " + e);
        }
    }

    // on refatoring proccess
    public void updateAllItems(UpdateDTO updateDTO) throws Exception {
        try {
           
            Optional<Items> optionalItem = itemsRepository.findById(updateDTO.getItemsDTO().getItemId());
            Items items = optionalItem.get();

            updateItemsWithDTO(items, updateDTO.getItemsDTO(), updateDTO.getUpdateAt());
            itemsRepository.save(items);
            Optional<Users> optionalUser = usersRepository.findById(updateDTO.getUsersDTO().getId());
            Users user = optionalUser.get();
            updateUserWithDTO(user, updateDTO.getUsersDTO(),updateDTO.getUpdateAt());
            usersRepository.save(user);
            Optional<Descriptions> optionalDescription = descriptionsRepository
                    .findById(updateDTO.getDescriptionsDTO().getDescriptionId());
            Descriptions description = optionalDescription.get();
            updateDescriptionWithDTO(description, updateDTO.getDescriptionsDTO(), updateDTO.getUpdateAt());
            descriptionsRepository.save(description);
            Optional<CostCenter> optionalCostCenter = costCenterRepository
                    .findById(updateDTO.getCostCenterDTO().getCostCenterId());
            CostCenter costCenter = optionalCostCenter.get();
            updateCostCenterWithDTO(costCenter, updateDTO.getCostCenterDTO(), updateDTO.getUpdateAt());
            costCenterRepository.save(costCenter);
            Optional<Contacts> optionalContact = contactsRepository.findById(updateDTO.getContactsDTO().getContactId());
            Contacts contact = optionalContact.get();
            updateContactWithDTO(contact, updateDTO.getContactsDTO(), updateDTO.getUpdateAt());
            contactsRepository.save(contact);

        } catch (Exception e) {
            throw new Exception("Erro ao tentar atualizar dados: " + e.getMessage(), e);
        }
    }

    private void updateItemsWithDTO(Items items, ItemsDTO itemsDTO, LocalDateTime time){
        items.setNfInvoice(itemsDTO.getNfInvoice());
        items.setNumber(itemsDTO.getCode());
        items.setObservation(itemsDTO.getObservation());
        items.setPathImage(itemsDTO.getImagePath());
        items.setOrder(itemsDTO.getOrderOrigin());
        items.setSde(itemsDTO.getSde());
        items.setStatus(itemsDTO.getStatus());
        items.setValue(itemsDTO.getValue());
        items.setLastModification(itemsDTO.getLastModification());
        items.setUpdateIn(time);

    }

    private void updateUserWithDTO(Users user, UsersDTO usersDTO,LocalDateTime time) {
        user.setName(usersDTO.getUserName());
        user.setType(usersDTO.getUserType());
        user.setLastModification(usersDTO.getLastModification());
        user.setUpdateIn(time);
    }

    private void updateDescriptionWithDTO(Descriptions description, DescriptionsDTO descriptionsDTO,LocalDateTime time) {
        description.setBrand(descriptionsDTO.getBrand());
        description.setDescription(descriptionsDTO.getDescription());
        description.setLocal(descriptionsDTO.getLocation());
        description.setModel(descriptionsDTO.getModel());
        description.setSerie(descriptionsDTO.getSeries());
        description.setLastModification(descriptionsDTO.getLastModification());
        description.setUpdateIn(time);
    }

    private void updateCostCenterWithDTO(CostCenter costCenter, CostCenterDTO costCenterDTO, LocalDateTime time) {
        costCenter.setName(costCenterDTO.getCostCenterName());
        costCenter.setIdentification(costCenterDTO.getCostCenterIdentification());
        costCenter.setInitialDate(costCenterDTO.getCostCenterStartDate());
        costCenter.setEndDate(costCenterDTO.getCostCenterEndDate());
        costCenter.setLastModification(costCenterDTO.getLastModification());
        costCenter.setUpdateIn(time);
    }

    private void updateContactWithDTO(Contacts contact, ContactsDTO contactsDTO, LocalDateTime time) {
        contact.setEmail(contactsDTO.getContactEmail());
        contact.setOccupation(contactsDTO.getContactOccupation());
        contact.setPhone(contactsDTO.getContactPhone());
        contact.setLastModification(contactsDTO.getLastModification());
        contact.setUpdateIn(time);
    }

}
