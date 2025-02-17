package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.asset.common.OHLCV;
import com.am.common.amcommondata.model.asset.common.OHLCVModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OHLCVMapper {
    
    @Mapping(target = "id", ignore = true)
    OHLCV toEntity(OHLCVModel model);
    
    OHLCVModel toModel(OHLCV entity);
    
    @Mapping(target = "id", ignore = true)
    OHLCV updateEntity(@MappingTarget OHLCV entity, OHLCVModel model);
}
