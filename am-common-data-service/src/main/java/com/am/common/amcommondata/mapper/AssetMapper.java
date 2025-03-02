package com.am.common.amcommondata.mapper;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.asset.AssetModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
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
    Asset toEntity(AssetModel model);

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
        //entity.setInvestmentValue(model.getInvestmentValue());

        return entity;
    }
}
