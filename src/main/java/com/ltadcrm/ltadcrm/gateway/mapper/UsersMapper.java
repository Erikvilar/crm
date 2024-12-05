package com.ltadcrm.ltadcrm.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.ltadcrm.ltadcrm.DTO.domainDTO.UsersDTO;
import com.ltadcrm.ltadcrm.domain.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {
        Users updateDomainFromDTO(@MappingTarget Users users, UsersDTO usersDTO);
}
