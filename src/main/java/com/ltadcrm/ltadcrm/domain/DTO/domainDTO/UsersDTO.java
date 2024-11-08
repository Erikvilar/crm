package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsersDTO(

        @JsonProperty("id") Long idUsers,
        @JsonProperty("usuario") String name,
        @JsonProperty("tipo") String type) {
}
