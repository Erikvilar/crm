package com.ltadcrm.ltadcrm.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ContactsDTO;

@Mapper(componentModel = "spring")
public interface  ContactsMapper {
    Contacts updateDomainFromDTO(@MappingTarget Contacts contacts, ContactsDTO contactsDTO);
}
