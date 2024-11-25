package com.ltadcrm.ltadcrm.gateway.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemsDTO;
@Mapper(componentModel = "spring")
public interface ItemsMapper {
    ItemsMapper INSTANCE = Mappers.getMapper(ItemsMapper.class);


    Items updateDomainFromDTO(@MappingTarget Items item, ItemsDTO dto);


}
