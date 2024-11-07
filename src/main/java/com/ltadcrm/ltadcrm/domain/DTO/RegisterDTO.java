package com.ltadcrm.ltadcrm.domain.DTO;

import com.ltadcrm.ltadcrm.domain.Enums.AccountRoles;

public record RegisterDTO(String login, String password, AccountRoles role) {
    
}
