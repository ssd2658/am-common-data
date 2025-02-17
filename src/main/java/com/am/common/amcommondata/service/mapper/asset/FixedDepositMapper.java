package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.fixeddeposit.FixedDeposit;
import com.am.common.amcommondata.model.asset.fixeddeposit.FixedDepositModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FixedDepositMapper {
    
    FixedDeposit toEntity(FixedDepositModel model);
    
    FixedDepositModel toModel(FixedDeposit entity);
    
    FixedDeposit updateEntity(@MappingTarget FixedDeposit entity, FixedDepositModel model);
}
