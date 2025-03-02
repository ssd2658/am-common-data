package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.pension.NPS;
import com.am.common.amcommondata.model.asset.pension.NPSModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NPSMapper {
    
    @Mapping(target = "id", ignore = true)
    NPS toEntity(NPSModel model);
    
    NPSModel toModel(NPS entity);
    
    @Mapping(target = "id", ignore = true)
    NPS updateEntity(@MappingTarget NPS entity, NPSModel model);
}
