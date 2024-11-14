package com.ltadcrm.ltadcrm.usescases.mapper;

import org.mapstruct.Mapper;

import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemsDTO;

@Mapper(componentModel = "spring")
public interface ItemsMapper {

    ItemsDTO toDto(Items items);

    Items toEntity(ItemsDTO itemsDTO);

}
