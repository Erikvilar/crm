package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DescriptionsDTO(

        @JsonProperty("id") Long idDescriptions,
        @JsonProperty("modelo") String model,
        @JsonProperty("marca") String brand,
        @JsonProperty("serie") String serie,
        @JsonProperty("descrição") String description,
        @JsonProperty("localização") String local

) {
}
