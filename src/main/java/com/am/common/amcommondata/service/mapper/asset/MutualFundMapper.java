package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.mutualfund.MutualFund;
import com.am.common.amcommondata.model.asset.mutualfund.MutualFundModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MutualFundMapper {
    
    @Mapping(target = "id", ignore = true)
    MutualFund toEntity(MutualFundModel model);
    
    MutualFundModel toModel(MutualFund entity);
    
    @Mapping(target = "id", ignore = true)
    MutualFund updateEntity(@MappingTarget MutualFund entity, MutualFundModel model);
}
