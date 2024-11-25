package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ltadcrm.ltadcrm.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsersDTO {

        @JsonProperty("id_usuario")
        private Long id;
        @JsonProperty("nome_usuario")
        private String userName;
        @JsonProperty("tipo_usuario")
        private String userType;
        @JsonProperty("lastModify")
        private String lastModification;
        @JsonProperty("updateIn")
        private LocalDateTime updateIn;

      
}