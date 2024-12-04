package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;



import java.time.LocalDateTime;

import com.ltadcrm.ltadcrm.domain.Account;
import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.DTO.authentication.AuthenticationDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateDTO {
   
    AuthenticationDTO authenticationDTO;


    private ItemsDTO itemsDTO;
    private UsersDTO usersDTO;
    private DetailsDTO detailsDTO;
    private CostCenterDTO costCenterDTO;
    private ContactsDTO contactsDTO;
    private LocalDateTime updateAt = LocalDateTime.now();
   

    



}
