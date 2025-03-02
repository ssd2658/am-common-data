package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.asset.equity.Equity;
import com.am.common.amcommondata.model.asset.AssetModel;
import com.am.common.amcommondata.model.enums.AssetType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {MarketDataMapper.class})
@Component
public interface AssetMapper {
    @Mapping(target = "marketData", ignore = true)
    @Mapping(target = "currentValue", ignore = true)
    @Mapping(target = "profitLoss", ignore = true)
    @Mapping(target = "profitLossPercentage", ignore = true)
    AssetModel toModel(Asset entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    default Asset toEntity(AssetModel model) {
        if (model == null) {
            return null;
        }

        Asset asset;
        if (model.getAssetType() == AssetType.EQUITY) {
            asset = new Equity();
        } else {
            throw new UnsupportedOperationException("Asset type not supported: " + model.getAssetType());
        }

        asset.setSymbol(model.getSymbol());
        asset.setName(model.getName());
        asset.setDescription(model.getDescription());
        asset.setAssetType(model.getAssetType());
        asset.setBrokerType(model.getBrokerType());
        asset.setInvestmentValue(model.getInvestmentValue());

        return asset;
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    default Asset updateEntity(@MappingTarget Asset entity, AssetModel model) {
        if (model == null) {
            return entity;
        }

        entity.setSymbol(model.getSymbol());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setAssetType(model.getAssetType());
        entity.setBrokerType(model.getBrokerType());
        entity.setInvestmentValue(model.getInvestmentValue());

        return entity;
    }
}
