package com.ltadcrm.ltadcrm.usescases.mapper;

import com.ltadcrm.ltadcrm.domain.Users;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UsersDTO;

public interface UsersMapper {
        Users toDomain (UsersDTO usersDTO);
        UsersDTO toDto(Users users);
        
}   
