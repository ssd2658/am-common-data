package com.am.common.amcommondata.mapper;

import com.am.common.amcommondata.domain.portfolio.Portfolio;
import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.PortfolioModel;
import com.am.common.amcommondata.model.asset.AssetModel;
import com.am.common.amcommondata.model.enums.FundType;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {AssetMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PortfolioMapper {
    
    @Autowired
    protected AssetMapper assetMapper;
    
    @Mappings({
        @Mapping(target = "totalValue", qualifiedByName = "calculateTotalValue", source = "entity"),
        @Mapping(target = "assetCount", qualifiedByName = "getAssetCount", source = "entity"),
        @Mapping(target = "fundType", qualifiedByName = "determineFundType", source = "entity"),
        @Mapping(target = "status", qualifiedByName = "determinePortfolioStatus", source = "entity"),
        @Mapping(target = "assets", qualifiedByName = "mapAssetsIfPresent", source = "entity")
    })
    public abstract PortfolioModel toModel(Portfolio entity);
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())"),
        @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())"),
        @Mapping(target = "createdBy", source = "model.owner"),
        @Mapping(target = "updatedBy", source = "model.owner"),
        @Mapping(target = "version", ignore = true),
        @Mapping(target = "assets", qualifiedByName = "mapModelAssetsToEntities", source = "model.assets")
    })
    public abstract Portfolio toEntity(PortfolioModel model);
    
    @Mappings({
        @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())"),
        @Mapping(target = "updatedBy", source = "model.owner"),
        @Mapping(target = "assets", qualifiedByName = "mapModelAssetsToEntities", source = "model.assets")
    })
    public abstract Portfolio updateEntity(@MappingTarget Portfolio entity, PortfolioModel model);
    
    @Named("mapModelAssetsToEntities")
    protected Set<Asset> mapModelAssetsToEntities(Set<AssetModel> assets) {
        if (assets == null || assets.isEmpty()) {
            return new HashSet<>();
        }
        Set<Asset> entityAssets = new HashSet<>();
        for (AssetModel assetModel : assets) {
            Asset asset = assetMapper.toEntity(assetModel);
            entityAssets.add(asset);
        }
        return entityAssets;
    }

    @Named("calculateTotalValue")
    protected Double calculateTotalValue(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null) {
            return 0.0;
        }
        return portfolio.getAssets().stream()
                .filter(asset -> asset != null && asset.getCurrentValue() != null)
                .mapToDouble(Asset::getCurrentValue)
                .sum();
    }

    @Named("determineFundType")
    protected FundType determineFundType(Portfolio portfolio) {
        if (portfolio == null || portfolio.getFundType() == null) {
            return null;
        }
        return portfolio.getFundType();
    }
    
    @Named("determinePortfolioStatus")
    protected String determinePortfolioStatus(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null) {
            return "EMPTY";
        }
        return portfolio.getAssets().isEmpty() ? "EMPTY" : "ACTIVE";
    }
    
    @Named("getAssetCount")
    protected Integer getAssetCount(Portfolio portfolio) {
        if (portfolio == null || portfolio.getAssets() == null || portfolio.getAssets().isEmpty()) {
            return null;
        }
        return portfolio.getAssets().size();
    }
    
    @Named("mapAssetsIfPresent")
    protected Set<AssetModel> mapAssetsIfPresent(Portfolio portfolio) {
        if (portfolio == null) {
            return new HashSet<>();
        }
        return mapAssets(portfolio.getAssets());
    }
    
    @Named("mapAssets")
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
