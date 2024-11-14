package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionsDTO {
  
  @JsonProperty("id_descricao")
  private Long descriptionId;

  @JsonProperty("marca_descricao")
  private String brand;

  @JsonProperty("descricao_item")
  private String description;

  @JsonProperty("localizacao_descricao")
  private String location;

  @JsonProperty("modelo_descricao")
  private String model;

  @JsonProperty("serie_descricao")
  private String series;
  @JsonProperty("lastModify")
  private String lastModification;
  @JsonProperty("updateIn")
  private LocalDateTime updateIn;

}
