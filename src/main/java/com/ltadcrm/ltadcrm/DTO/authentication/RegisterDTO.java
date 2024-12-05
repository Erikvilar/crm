package com.ltadcrm.ltadcrm.DTO.authentication;

import com.ltadcrm.ltadcrm.DTO.Enums.AccountRoles;

public record RegisterDTO(String login, String password, AccountRoles role) {

}