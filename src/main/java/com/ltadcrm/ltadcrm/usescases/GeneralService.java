package com.ltadcrm.ltadcrm.usescases;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.CostCenter;
import com.ltadcrm.ltadcrm.domain.Descriptions;
import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.Users;


import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;

import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UpdateDTO;

import com.ltadcrm.ltadcrm.repositories.ContactsRepository;
import com.ltadcrm.ltadcrm.repositories.CostCenterRepository;
import com.ltadcrm.ltadcrm.repositories.DescriptionsRepository;
import com.ltadcrm.ltadcrm.repositories.ItemsRepository;
import com.ltadcrm.ltadcrm.repositories.UsersRepository;
import com.ltadcrm.ltadcrm.usescases.mapper.ContactsMapper;
import com.ltadcrm.ltadcrm.usescases.mapper.ItemsMapper;
import com.ltadcrm.ltadcrm.usescases.strategy.ItemDetailsDTOConvertImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;

@Service
public class GeneralService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ContactsMapper contactsMapper;
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
    
 

    public List<ItemDetailDTO> list() throws Exception {
        try {

            List<ItemDetailDTO> dtos = new ArrayList<>();
            for (Tuple tuple : itemsRepository.findAllItemsDTOs()) {
                ItemDetailDTO dto = convert.convert(tuple);
                dtos.add(dto);
            }
            return dtos;
        } catch (Exception e) {
            throw new Exception("Current error in ItemService " + e);
        }
    }

    // on refatoring proccess
    public void update(UpdateDTO updateDTO) throws Exception {
        try {

            Items items = itemsMapper.toDomain(updateDTO.getItemsDTO());
            itemsRepository.save(items);
            Contacts contacts = contactsMapper.toDomain(updateDTO.getContactsDTO());
            contactsRepository.save(contacts);
            Users users 
            
        
        } catch (Exception e) {
            throw new Exception("Erro ao tentar atualizar dados: " + e.getMessage(), e);
        }
    }

    public void create(UpdateDTO updateDTO) throws Exception {
        try {
            // Criar a entidade Item
            Items item = new Items();
            item.setNumber(updateDTO.getItemsDTO().getNumber());
            item.setObservation(updateDTO.getItemsDTO().getObservation());
            item.setPathImage(updateDTO.getItemsDTO().getImagePath());
            item.setSde(updateDTO.getItemsDTO().getSde());
            item.setOrder(updateDTO.getItemsDTO().getOrder());
            item.setStatus(updateDTO.getItemsDTO().getStatus());
            item.setNfInvoice(updateDTO.getItemsDTO().getNfInvoice());
            item.setValue(updateDTO.getItemsDTO().getValue());
            item.setLastModification(updateDTO.getItemsDTO().getLastModification());
            item.setUpdateIn(updateDTO.getUpdateAt());

            // Criar e associar as entidades relacionadas sem IDs
            Users user = new Users();
            user.setUserName(updateDTO.getUsersDTO().getUserName());
            user.setType(updateDTO.getUsersDTO().getUserType());
            user.setLastModification(updateDTO.getUsersDTO().getLastModification());

            Descriptions description = new Descriptions();
            description.setBrand(updateDTO.getDescriptionsDTO().getBrand());
            description.setDescription(updateDTO.getDescriptionsDTO().getDescription());
            description.setLocal(updateDTO.getDescriptionsDTO().getLocal());
            description.setModel(updateDTO.getDescriptionsDTO().getModel());
            description.setSerie(updateDTO.getDescriptionsDTO().getSerial());
            description.setLastModification(updateDTO.getDescriptionsDTO().getLastModification());

            CostCenter costCenter = new CostCenter();
            costCenter.setName(updateDTO.getCostCenterDTO().getName());
            costCenter.setIdentification(updateDTO.getCostCenterDTO().getIdentification());
            costCenter.setInitialDate(updateDTO.getCostCenterDTO().getStartDate());
            costCenter.setEndDate(updateDTO.getCostCenterDTO().getEndDate());
            costCenter.setLastModification(updateDTO.getCostCenterDTO().getLastModification());

            Contacts contact = new Contacts();
            contact.setEmail(updateDTO.getContactsDTO().getEmail());
            contact.setOccupation(updateDTO.getContactsDTO().getOccupation());
            contact.setPhone(updateDTO.getContactsDTO().getPhone());
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

}
