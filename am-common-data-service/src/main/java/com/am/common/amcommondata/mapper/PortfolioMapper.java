package com.am.common.amcommondata.mapper;

import com.am.common.amcommondata.domain.portfolio.Portfolio;
import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.PortfolioModel;
import com.am.common.amcommondata.model.asset.AssetModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {AssetMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public abstract class PortfolioMapper {
    
    @Autowired
    protected AssetMapper assetMapper;
    
    @Mapping(target = "totalValue", expression = "java(calculateTotalValue(entity))")
    @Mapping(target = "assetCount", expression = "java(getAssetCount(entity))")
    @Mapping(target = "status", expression = "java(determinePortfolioStatus(entity))")
    @Mapping(target = "assets", expression = "java(mapAssetsIfPresent(entity))")
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
                .filter(asset -> asset != null && asset.getCurrentValue() != null)
                .mapToDouble(Asset::getCurrentValue)
                .sum();
    }
    
    protected String determinePortfolioStatus(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null) {
            return "EMPTY";
        }
        return portfolio.getAssets().isEmpty() ? "EMPTY" : "ACTIVE";
    }
    
    protected Integer getAssetCount(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null || portfolio.getAssets().isEmpty()) {
            return null;
        }
        return portfolio.getAssets().size();
    }
    
    protected Set<AssetModel> mapAssetsIfPresent(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null || portfolio.getAssets().isEmpty()) {
            return null;
        }
        return mapAssets(portfolio.getAssets());
    }
    
    protected Set<AssetModel> mapAssets(Set<Asset> assets) {
        if (assets == null) {
            return new HashSet<>();
        }
        return assets.stream()
                .filter(asset -> asset != null)
                .map(assetMapper::toModel)
                .collect(Collectors.toSet());
    }
}
