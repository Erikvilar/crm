package com.ltadcrm.ltadcrm.gateway;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UpdateDTO;
import com.ltadcrm.ltadcrm.gateway.mapper.ContactsMapper;
import com.ltadcrm.ltadcrm.gateway.mapper.CostCenterMapper;
import com.ltadcrm.ltadcrm.gateway.mapper.DetailsMapper;
import com.ltadcrm.ltadcrm.gateway.mapper.ItemsMapper;
import com.ltadcrm.ltadcrm.gateway.mapper.UsersMapper;
import com.ltadcrm.ltadcrm.repositories.ContactsRepository;
import com.ltadcrm.ltadcrm.repositories.CostCenterRepository;
import com.ltadcrm.ltadcrm.repositories.DetailsRepository;
import com.ltadcrm.ltadcrm.repositories.ItemsRepository;
import com.ltadcrm.ltadcrm.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateAllEntities {

    private final ContactsMapper contactsMapper;
    private final UsersMapper usersMapper;
    private final ItemsMapper itemsMapper;
    private final DetailsMapper detailsMapper;
    private final CostCenterMapper costCenterMapper;

    private final ItemsRepository itemsRepository;
    private final ContactsRepository contactsRepository;
    private final CostCenterRepository costCenterRepository;
    private final DetailsRepository detailsRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public ResponseEntity<String> update(UpdateDTO updateDTO) {
        try {

            itemsRepository.save(itemsMapper.updateDomainFromDTO(
                    itemsRepository.findById(updateDTO.getItemsDTO().getId()).get(), updateDTO.getItemsDTO()));
            usersRepository.save(usersMapper.updateDomainFromDTO(
                    usersRepository.findById(updateDTO.getContactsDTO().getId()).get(), updateDTO.getUsersDTO()));
            detailsRepository.save(detailsMapper.updateDomainFromDTO(
                    detailsRepository.findById(updateDTO.getDetailsDTO().getId()).get(), updateDTO.getDetailsDTO()));
            contactsRepository.save(contactsMapper.updateDomainFromDTO(
                    contactsRepository.findById(updateDTO.getContactsDTO().getId()).get(), updateDTO.getContactsDTO()));
            costCenterRepository.save(costCenterMapper.updateDomainFromDTO(
                    costCenterRepository.findById(updateDTO.getCostCenterDTO().getId()).get(),
                    updateDTO.getCostCenterDTO()));
            return ResponseEntity.ok("Dados salvos");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e);
        }
    }
}
