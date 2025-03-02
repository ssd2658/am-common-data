package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.common.TimeSeriesData;
import com.am.common.amcommondata.model.asset.common.TimeSeriesDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {OHLCVMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TimeSeriesDataMapper {
    
    @Mapping(target = "id", ignore = true)
    TimeSeriesData toEntity(TimeSeriesDataModel model);
    
    TimeSeriesDataModel toModel(TimeSeriesData entity);
    
    @Mapping(target = "id", ignore = true)
    TimeSeriesData updateEntity(@MappingTarget TimeSeriesData entity, TimeSeriesDataModel model);
}
