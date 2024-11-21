package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;



import java.time.LocalDateTime;

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
    private LocalDateTime updateAt = LocalDateTime.now();
    private String userLogged;





}
