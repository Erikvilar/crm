package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostCenterDTO{
        @JsonProperty("id_centro_custo")
        private Long costCenterId;
    
        @JsonProperty("nome_centro_custo")
        private String costCenterName;
    
        @JsonProperty("identificacao_centro_custo")
        private String costCenterIdentification;
    
        @JsonProperty("data_inicio_centro_custo")
        private Date costCenterStartDate;
    
        @JsonProperty("data_fim_centro_custo")
        private Date costCenterEndDate;

}
