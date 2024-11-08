package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CostCenterDTO(

        @JsonProperty("id") Long idCostCenter,
        @JsonProperty("nome") String name,
        @JsonProperty("identificação") String identification,
        @JsonProperty("Data de inicio") Date initialDate,
        @JsonProperty("Data de fim") Date endDate)

{
}
