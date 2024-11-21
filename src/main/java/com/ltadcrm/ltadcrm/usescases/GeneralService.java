package com.ltadcrm.ltadcrm.usescases;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.CostCenter;
import com.ltadcrm.ltadcrm.domain.Descriptions;
import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.Users;

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

import jakarta.persistence.EntityNotFoundException;
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



    public void createItem(UpdateDTO updateDTO) throws Exception {
        try {
            // Criar a entidade Item
            Items item = new Items();
            item.setNumber(updateDTO.getItemsDTO().getCode());
            item.setObservation(updateDTO.getItemsDTO().getObservation());
            item.setPathImage(updateDTO.getItemsDTO().getImagePath());
            item.setSde(updateDTO.getItemsDTO().getSde());
            item.setOrder(updateDTO.getItemsDTO().getOrderOrigin());
            item.setStatus(updateDTO.getItemsDTO().getStatus());
            item.setNfInvoice(updateDTO.getItemsDTO().getNfInvoice());
            item.setValue(updateDTO.getItemsDTO().getValue());
            item.setLastModification(updateDTO.getItemsDTO().getLastModification());
            item.setUpdateIn(updateDTO.getUpdateAt());
    
            // Criar e associar as entidades relacionadas sem IDs
            Users user = new Users();
            user.setName(updateDTO.getUsersDTO().getUserName());
            user.setType(updateDTO.getUsersDTO().getUserType());
            user.setLastModification(updateDTO.getUsersDTO().getLastModification());
    
            Descriptions description = new Descriptions();
            description.setBrand(updateDTO.getDescriptionsDTO().getBrand());
            description.setDescription(updateDTO.getDescriptionsDTO().getDescription());
            description.setLocal(updateDTO.getDescriptionsDTO().getLocation());
            description.setModel(updateDTO.getDescriptionsDTO().getModel());
            description.setSerie(updateDTO.getDescriptionsDTO().getSeries());
            description.setLastModification(updateDTO.getDescriptionsDTO().getLastModification());
    
            CostCenter costCenter = new CostCenter();
            costCenter.setName(updateDTO.getCostCenterDTO().getCostCenterName());
            costCenter.setIdentification(updateDTO.getCostCenterDTO().getCostCenterIdentification());
            costCenter.setInitialDate(updateDTO.getCostCenterDTO().getCostCenterStartDate());
            costCenter.setEndDate(updateDTO.getCostCenterDTO().getCostCenterEndDate());
            costCenter.setLastModification(updateDTO.getCostCenterDTO().getLastModification());
    
            Contacts contact = new Contacts();
            contact.setEmail(updateDTO.getContactsDTO().getContactEmail());
            contact.setOccupation(updateDTO.getContactsDTO().getContactOccupation());
            contact.setPhone(updateDTO.getContactsDTO().getContactPhone());
            contact.setLastModification(updateDTO.getContactsDTO().getLastModification());
    
            // Associar as entidades criadas
            item.setUsers(user);
            item.setDescriptions(description);
            item.setCostCenter(costCenter);
          
    
            // Salvar as entidades no banco de dados
            usersRepository.save(user);
            descriptionsRepository.save(description);
            costCenterRepository.save(costCenter);
            contactsRepository.save(contact);
            itemsRepository.save(item);
    
        } catch (Exception e) {
            throw new Exception("Erro ao tentar salvar os dados: " + e.getMessage(), e);
        }
    }

   public void deleteItem(Long id) throws Exception {
        Optional<Items> optionalItem = itemsRepository.findById(id);

        if (optionalItem.isPresent()) {
            // Item encontrado, realiza a deleção
            itemsRepository.delete(optionalItem.get());
        } else {
            // Caso o item não seja encontrado, lança uma exceção
            throw new EntityNotFoundException("Item não encontrado com o ID: " + id);
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
