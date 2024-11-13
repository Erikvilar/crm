package com.ltadcrm.ltadcrm.usescases;

import java.util.ArrayList;
import java.util.Date;
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

import jakarta.persistence.Tuple;

@Service
public class GeneralService {

    ItemsRepository itemsRepository;
    UsersRepository usersRepository;
    CostCenterRepository costCenterRepository;
    ContactsRepository contactsRepository;
    DescriptionsRepository descriptionsRepository;

    public GeneralService(
            ItemsRepository itemsRepository,
            UsersRepository usersRepository,
            DescriptionsRepository descriptionsRepository,
            CostCenterRepository costCenterRepository,
            ContactsRepository contactsRepository) {
        this.itemsRepository = itemsRepository;
        this.usersRepository = usersRepository;
        this.descriptionsRepository = descriptionsRepository;
        this.costCenterRepository = costCenterRepository;
        this.contactsRepository = contactsRepository;

    }

    public List<ItemDetailDTO> getItemDetails() throws Exception {
        try {
            List<Tuple> tuples = itemsRepository.findAllItemsDTOs();
            List<ItemDetailDTO> dtos = new ArrayList<>();
            for (Tuple tuple : tuples) {
                ItemDetailDTO dto = new ItemDetailDTO(
                        tuple.get("id_usuario", Long.class),
                        tuple.get("nome_usuario", String.class),
                        tuple.get("tipo_usuario", String.class),
                        tuple.get("id_item", Long.class),
                        tuple.get("nf_invoice_item", String.class),
                        tuple.get("codigo_item", String.class),
                        tuple.get("observacao_item", String.class),
                        tuple.get("caminho_imagem_item", String.class),
                        tuple.get("pedido_origem", String.class),
                        tuple.get("sde_item", Long.class),
                        tuple.get("status_item", String.class),
                        tuple.get("valor_item", Double.class),
                        tuple.get("id_descricao", Long.class),
                        tuple.get("marca_descricao", String.class),
                        tuple.get("descricao_item", String.class),
                        tuple.get("localizacao_descricao", String.class),
                        tuple.get("modelo_descricao", String.class),
                        tuple.get("serie_descricao", String.class),
                        tuple.get("id_centro_custo", Long.class),
                        tuple.get("nome_centro_custo", String.class),
                        tuple.get("identificacao_centro_custo", String.class),
                        tuple.get("data_inicio_centro_custo", Date.class),
                        tuple.get("data_fim_centro_custo", Date.class),
                        tuple.get("id_contato", Long.class),
                        tuple.get("email_contato", String.class),
                        tuple.get("ocupacao_contato", String.class),
                        tuple.get("telefone_contato", String.class));
                dtos.add(dto);
            }
            return dtos;
        } catch (Exception e) {
            throw new Exception("Current error in ItemService " + e);
        }
    }
        //on refatoring proccess 
    public void updateAllItems(UpdateDTO updateDTO) throws Exception{
      try {
            
            Optional<Items> optionalItem = itemsRepository.findById(updateDTO.getItemsDTO().getItemId());
            Items items = optionalItem.get();
            updateItemsWithDTO(items, updateDTO.getItemsDTO());
            itemsRepository.save(items);
            Optional<Users> optionalUser = usersRepository.findById(updateDTO.getUsersDTO().getId());
            Users user = optionalUser.get();
            updateUserWithDTO(user, updateDTO.getUsersDTO());
            usersRepository.save(user);
            Optional<Descriptions> optionalDescription = descriptionsRepository.findById(updateDTO.getDescriptionsDTO().getDescriptionId());
            Descriptions description = optionalDescription.get();
            updateDescriptionWithDTO(description, updateDTO.getDescriptionsDTO());
            descriptionsRepository.save(description);
            Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(updateDTO.getCostCenterDTO().getCostCenterId());
            CostCenter costCenter = optionalCostCenter.get();
            updateCostCenterWithDTO(costCenter, updateDTO.getCostCenterDTO());
            costCenterRepository.save(costCenter);
            Optional<Contacts> optionalContact = contactsRepository.findById(updateDTO.getContactsDTO().getContactId());
            Contacts contact = optionalContact.get();
            updateContactWithDTO(contact, updateDTO.getContactsDTO());
            contactsRepository.save(contact);

        } catch (Exception e) {
            throw new Exception("Erro ao tentar atualizar dados: " + e.getMessage(), e);
        }
    }

    private void updateItemsWithDTO(Items items, ItemsDTO itemsDTO) {
        items.setNfInvoice(itemsDTO.getNfInvoice());
        items.setNumber(itemsDTO.getCode());
        items.setObservation(itemsDTO.getObservation());
        items.setPathImage(itemsDTO.getImagePath());
        items.setOrder(itemsDTO.getOrderOrigin());
        items.setSde(itemsDTO.getSde());
        items.setStatus(itemsDTO.getStatus());
        items.setValue(itemsDTO.getValue());
    }

    private void updateUserWithDTO(Users user, UsersDTO usersDTO) {
        user.setName(usersDTO.getUserName());
        user.setType(usersDTO.getUserType());
    }

    private void updateDescriptionWithDTO(Descriptions description, DescriptionsDTO descriptionsDTO) {
        description.setBrand(descriptionsDTO.getBrand());
        description.setDescription(descriptionsDTO.getDescription());
        description.setLocal(descriptionsDTO.getLocation());
        description.setModel(descriptionsDTO.getModel());
        description.setSerie(descriptionsDTO.getSeries());
    }

    private void updateCostCenterWithDTO(CostCenter costCenter, CostCenterDTO costCenterDTO) {
        costCenter.setName(costCenterDTO.getCostCenterName());
        costCenter.setIdentification(costCenterDTO.getCostCenterIdentification());
        costCenter.setInitialDate(costCenterDTO.getCostCenterStartDate());
        costCenter.setEndDate(costCenterDTO.getCostCenterEndDate());
    }

    private void updateContactWithDTO(Contacts contact, ContactsDTO contactsDTO) {
        contact.setEmail(contactsDTO.getContactEmail());
        contact.setOccupation(contactsDTO.getContactOccupation());
        contact.setPhone(contactsDTO.getContactPhone());
    }

}
