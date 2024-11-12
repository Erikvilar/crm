package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;


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
