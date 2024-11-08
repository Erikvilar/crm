package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactsDTO(

        @JsonProperty("id") Long idContacts,
        @JsonProperty("email") String email,
        @JsonProperty("telefone") String phone,
        @JsonProperty("ocupação") String ocupação

) {
}
