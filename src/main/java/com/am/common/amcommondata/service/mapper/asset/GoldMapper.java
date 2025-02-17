package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.gold.Gold;
import com.am.common.amcommondata.model.asset.gold.GoldModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GoldMapper {
    
    @Mapping(target = "id", ignore = true)
    Gold toEntity(GoldModel model);
    
    GoldModel toModel(Gold entity);
    
    @Mapping(target = "id", ignore = true)
    Gold updateEntity(@MappingTarget Gold entity, GoldModel model);
}
