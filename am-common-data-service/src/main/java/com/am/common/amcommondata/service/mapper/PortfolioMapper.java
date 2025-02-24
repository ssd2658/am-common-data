package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.Portfolio;
import com.am.common.amcommondata.model.PortfolioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {AssetMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PortfolioMapper {
    
    @Mapping(target = "totalValue", expression = "java(calculateTotalValue(entity))")
    @Mapping(target = "assetCount", expression = "java(entity.getAssets().size())")
    @Mapping(target = "assetTypes", expression = "java(entity.getAssets().stream().map(asset -> asset.getAssetType().name()).collect(java.util.stream.Collectors.toSet()))")
    @Mapping(target = "status", expression = "java(determinePortfolioStatus(entity))")
    PortfolioModel toModel(Portfolio entity);
    
    Portfolio toEntity(PortfolioModel model);
    
    Portfolio updateEntity(@MappingTarget Portfolio entity, PortfolioModel model);
    
    default Double calculateTotalValue(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null) {
            return 0.0;
        }
        return portfolio.getAssets().stream()
                .filter(asset -> asset.getCurrentValue() != null)
                .mapToDouble(asset -> asset.getCurrentValue())
                .sum();
    }
    
    default String determinePortfolioStatus(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null || portfolio.getAssets().isEmpty()) {
            return "EMPTY";
        }
        return "ACTIVE";
    }
}
