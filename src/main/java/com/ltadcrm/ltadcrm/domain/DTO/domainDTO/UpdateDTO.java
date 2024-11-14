package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;


import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDTO {
    
    private ItemsDTO itemsDTO;
    private UsersDTO usersDTO;
    private DescriptionsDTO descriptionsDTO;
    private CostCenterDTO costCenterDTO;
    private ContactsDTO contactsDTO;
   
}
