package com.ltadcrm.ltadcrm.usescases.mapper;

import org.mapstruct.Mapper;

import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ContactsDTO;



@Mapper(componentModel = "spring")
public interface  ContactsMapper {

    Contacts toDomain(ContactsDTO contactsDTO);
    ContactsDTO contactsDTO(Contacts contacts);
}
