package com.ltadcrm.ltadcrm.gateway.mapper;



import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

import com.ltadcrm.ltadcrm.DTO.domainDTO.ItemsDTO;
import com.ltadcrm.ltadcrm.domain.InventoryItems;
@Mapper(componentModel = "spring")
public interface InventoryItemsMapper {

    InventoryItems updateDomainFromDTO(@MappingTarget InventoryItems item, ItemsDTO dto);


}
