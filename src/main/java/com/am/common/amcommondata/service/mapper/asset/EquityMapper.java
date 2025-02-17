package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.equity.Equity;
import com.am.common.amcommondata.model.asset.equity.EquityModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EquityMapper {
    
    @Mapping(target = "id", ignore = true)
    Equity toEntity(EquityModel model);
    
    EquityModel toModel(Equity entity);
    
    @Mapping(target = "id", ignore = true)
    Equity updateEntity(@MappingTarget Equity entity, EquityModel model);
}
