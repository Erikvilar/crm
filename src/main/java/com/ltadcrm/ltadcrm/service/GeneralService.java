package com.ltadcrm.ltadcrm.service;

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
import com.ltadcrm.ltadcrm.repository.ContactsRepository;
import com.ltadcrm.ltadcrm.repository.CostCenterRepository;
import com.ltadcrm.ltadcrm.repository.DescriptionsRepository;
import com.ltadcrm.ltadcrm.repository.ItemsRepository;
import com.ltadcrm.ltadcrm.repository.UsersRepository;

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

    public void updateAllItems(UpdateDTO updateDTO) throws Exception{
      try {
            // Verificar e atualizar o item
            if (updateDTO.getItemsDTO() == null || updateDTO.getItemsDTO().getItemId() == null) {
                throw new Exception("ID do item não informado ou nulo");
            }
            
            Optional<Items> optionalItem = itemsRepository.findById(updateDTO.getItemsDTO().getItemId());
            if (!optionalItem.isPresent()) {
                throw new Exception("Item com ID " + updateDTO.getItemsDTO().getItemId() + " não encontrado");
            }

            Items items = optionalItem.get();
            updateItemsWithDTO(items, updateDTO.getItemsDTO());
            itemsRepository.save(items);
            
            // Verificar e atualizar o usuário
            if (updateDTO.getUsersDTO() == null || updateDTO.getUsersDTO().getId() == null) {
                throw new Exception("ID do usuário não informado ou nulo");
            }

            Optional<Users> optionalUser = usersRepository.findById(updateDTO.getUsersDTO().getId());
            if (!optionalUser.isPresent()) {
                throw new Exception("Usuário com ID " + updateDTO.getUsersDTO().getId() + " não encontrado");
            }

            Users user = optionalUser.get();
            updateUserWithDTO(user, updateDTO.getUsersDTO());
            usersRepository.save(user);

            // Verificar e atualizar a descrição
            if (updateDTO.getDescriptionsDTO() == null || updateDTO.getDescriptionsDTO().getDescriptionId() == null) {
                throw new Exception("ID da descrição não informado ou nulo");
            }

            Optional<Descriptions> optionalDescription = descriptionsRepository.findById(updateDTO.getDescriptionsDTO().getDescriptionId());
            if (!optionalDescription.isPresent()) {
                throw new Exception("Descrição com ID " + updateDTO.getDescriptionsDTO().getDescriptionId() + " não encontrada");
            }

            Descriptions description = optionalDescription.get();
            updateDescriptionWithDTO(description, updateDTO.getDescriptionsDTO());
            descriptionsRepository.save(description);

            // Verificar e atualizar o centro de custo
            if (updateDTO.getCostCenterDTO() == null || updateDTO.getCostCenterDTO().getCostCenterId() == null) {
                throw new Exception("ID do centro de custo não informado ou nulo");
            }

            Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(updateDTO.getCostCenterDTO().getCostCenterId());
            if (!optionalCostCenter.isPresent()) {
                throw new Exception("Centro de custo com ID " + updateDTO.getCostCenterDTO().getCostCenterId() + " não encontrado");
            }

            CostCenter costCenter = optionalCostCenter.get();
            updateCostCenterWithDTO(costCenter, updateDTO.getCostCenterDTO());
            costCenterRepository.save(costCenter);

            // Verificar e atualizar o contato
            if (updateDTO.getContactsDTO() == null || updateDTO.getContactsDTO().getContactId() == null) {
                throw new Exception("ID do contato não informado ou nulo");
            }

            Optional<Contacts> optionalContact = contactsRepository.findById(updateDTO.getContactsDTO().getContactId());
            if (!optionalContact.isPresent()) {
                throw new Exception("Contato com ID " + updateDTO.getContactsDTO().getContactId() + " não encontrado");
            }

            Contacts contact = optionalContact.get();
            updateContactWithDTO(contact, updateDTO.getContactsDTO());
            contactsRepository.save(contact);

        } catch (Exception e) {
            throw new Exception("Erro ao tentar atualizar dados: " + e.getMessage(), e);
        }
    }

    // Métodos auxiliares para atualizar entidades com dados dos DTOs
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
