package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemsDTO(

        @JsonProperty("id") Long idItems,
        @JsonProperty("patrimonio") String number,
        @JsonProperty("observação") String observation,
        @JsonProperty("imagem")String pathImage,
        @JsonProperty("SDE")  Long sde,
        @JsonProperty("pedido") String pedido,
        @JsonProperty("status") String status,
        @JsonProperty("NF_INVOICE") String nfInvoice,
        @JsonProperty("valor") Double value,
        //Relational
        @JsonProperty("descricao") DescriptionsDTO descriptions,
        @JsonProperty("usuario") UsersDTO users,
        @JsonProperty("centroDeCusto") CostCenterDTO costCenter

        
        
) {}