package com.ltadcrm.ltadcrm.gateway.interfaces;

import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;

import jakarta.persistence.Tuple;

public interface ItemDetailsDTOConvert {
    ItemDetailDTO convert(Tuple tuple);

}