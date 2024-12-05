package com.ltadcrm.ltadcrm.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.ltadcrm.ltadcrm.DTO.domainDTO.CostCenterDTO;
import com.ltadcrm.ltadcrm.domain.CostCenter;

@Mapper(componentModel = "spring")
public interface CostCenterMapper {
    CostCenter updateDomainFromDTO(@MappingTarget CostCenter costCenter, CostCenterDTO costCenterDTO);
}
