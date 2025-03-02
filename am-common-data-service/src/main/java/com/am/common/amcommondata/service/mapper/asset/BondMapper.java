package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.bond.Bond;
import com.am.common.amcommondata.model.asset.bond.BondModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BondMapper {

    Bond toEntity(BondModel model);
    
    BondModel toModel(Bond entity);
    
    Bond updateEntity(@MappingTarget Bond entity, BondModel model);
}
