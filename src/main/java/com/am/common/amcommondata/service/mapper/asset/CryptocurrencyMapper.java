package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.cryptocurrency.Cryptocurrency;
import com.am.common.amcommondata.model.asset.cryptocurrency.CryptocurrencyModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CryptocurrencyMapper {
    
    @Mapping(target = "id", ignore = true)
    Cryptocurrency toEntity(CryptocurrencyModel model);
    
    CryptocurrencyModel toModel(Cryptocurrency entity);
    
    @Mapping(target = "id", ignore = true)
    Cryptocurrency updateEntity(@MappingTarget Cryptocurrency entity, CryptocurrencyModel model);
}
