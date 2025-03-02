package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.common.MarketData;
import com.am.common.amcommondata.model.asset.common.MarketDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {TimeSeriesDataMapper.class, OHLCVMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MarketDataMapper {
    
    MarketData toEntity(MarketDataModel model);
    
    MarketDataModel toModel(MarketData entity);
    
    MarketData updateEntity(@MappingTarget MarketData entity, MarketDataModel model);
}

