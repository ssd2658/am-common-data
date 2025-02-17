package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.realestate.RealEstate;
import com.am.common.amcommondata.model.asset.realestate.RealEstateModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RealEstateMapper {
    
    @Mapping(target = "id", ignore = true)
    RealEstate toEntity(RealEstateModel model);
    
    RealEstateModel toModel(RealEstate entity);
    
    @Mapping(target = "id", ignore = true)
    RealEstate updateEntity(@MappingTarget RealEstate entity, RealEstateModel model);
}
