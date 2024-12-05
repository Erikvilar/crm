package com.ltadcrm.ltadcrm.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.ltadcrm.ltadcrm.DTO.domainDTO.ContactsDTO;
import com.ltadcrm.ltadcrm.domain.Contacts;

@Mapper(componentModel = "spring")
public interface  ContactsMapper {
    Contacts updateDomainFromDTO(@MappingTarget Contacts contacts, ContactsDTO contactsDTO);
}
