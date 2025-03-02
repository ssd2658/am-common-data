package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.portfolio.Portfolio;
import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.PortfolioModel;
import com.am.common.amcommondata.model.asset.AssetModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {AssetMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PortfolioMapper {
    
    @Autowired
    protected AssetMapper assetMapper;
    
    @Mapping(target = "totalValue", expression = "java(calculateTotalValue(entity))")
    @Mapping(target = "assetCount", expression = "java(entity.getAssets().size())")
    @Mapping(target = "assetTypes", expression = "java(entity.getAssets().stream().map(asset -> asset.getAssetType().name()).collect(java.util.stream.Collectors.toSet()))")
    @Mapping(target = "status", expression = "java(determinePortfolioStatus(entity))")
    @Mapping(target = "assets", expression = "java(mapAssets(entity.getAssets()))")
    public abstract PortfolioModel toModel(Portfolio entity);
    
    @Mapping(target = "assets", ignore = true)
    public abstract Portfolio toEntity(PortfolioModel model);
    
    @Mapping(target = "assets", ignore = true)
    public abstract Portfolio updateEntity(@MappingTarget Portfolio entity, PortfolioModel model);
    
    protected Double calculateTotalValue(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null) {
            return 0.0;
        }
        return portfolio.getAssets().stream()
                .filter(asset -> asset.getCurrentValue() != null)
                .mapToDouble(asset -> asset.getCurrentValue())
                .sum();
    }
    
    protected String determinePortfolioStatus(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null || portfolio.getAssets().isEmpty()) {
            return "EMPTY";
        }
        return "ACTIVE";
    }
    
    protected Set<AssetModel> mapAssets(Set<Asset> assets) {
        if (assets == null) {
            return null;
        }
        return assets.stream()
                .map(assetMapper::toModel)
                .collect(Collectors.toSet());
    }
}
