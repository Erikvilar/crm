package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactsDTO {

        @JsonProperty("id_contato")
        private Long contactId;
    
        @JsonProperty("email_contato")
        private String contactEmail;
    
        @JsonProperty("ocupacao_contato")
        private String contactOccupation;
    
        @JsonProperty("telefone_contato")
        private String contactPhone;
}
