package com.am.common.amcommondata.mapper;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.asset.AssetModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AssetMapper {

    @Mapping(target = "marketData", ignore = true)
    AssetModel toModel(Asset entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "portfolio", ignore = true)
    Asset toEntity(AssetModel model);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "portfolio", ignore = true)
    default Asset updateEntity(@MappingTarget Asset entity, AssetModel model) {
        if (model == null) {
            return entity;
        }

        entity.setSymbol(model.getSymbol());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setAssetType(model.getAssetType());
        entity.setBrokerType(model.getBrokerType());
        entity.setQuantity(model.getQuantity());
        entity.setAvgBuyingPrice(model.getAvgBuyingPrice());
        entity.setCurrentValue(model.getCurrentValue());

        return entity;
    }
}
