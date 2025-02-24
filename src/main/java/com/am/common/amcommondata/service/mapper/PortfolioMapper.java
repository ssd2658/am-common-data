package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.Portfolio;
import com.am.common.amcommondata.model.PortfolioModel;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PortfolioMapper {
    private final AssetMapper assetMapper;

    public PortfolioModel toModel(Portfolio entity) {
        if (entity == null) {
            return null;
        }

        return PortfolioModel.builder()
                //.id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .assets(entity.getAssets().stream()
                        .map(assetMapper::toModel)
                        .collect(Collectors.toSet()))
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedBy(entity.getUpdatedBy())
                .totalValue(calculateTotalValue(entity))
                .assetCount(entity.getAssets().size())
                .assetTypes(entity.getAssets().stream()
                        .map(asset -> asset.getAssetType().name())
                        .collect(Collectors.toSet()))
                .status(determinePortfolioStatus(entity))
                .build();
    }

    public Portfolio toEntity(PortfolioModel model) {
        if (model == null) {
            return null;
        }

        return Portfolio.builder()
                .name(model.getName())
                .description(model.getDescription())
                .createdBy(model.getCreatedBy())
                .updatedBy(model.getUpdatedBy())
                .build();
    }

    public Portfolio updateEntity(Portfolio entity, PortfolioModel model) {
        if (model == null) {
            return entity;
        }

        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setUpdatedBy(model.getUpdatedBy());
        return entity;
    }

    private Double calculateTotalValue(Portfolio portfolio) {
        return 0.0;
        // return portfolio.getAssets().stream()
        //         .mapToDouble(asset -> asset.getMarketData().getMarketPrice())
        //         .sum();
    }

    private String determinePortfolioStatus(Portfolio portfolio) {
        if (portfolio.getAssets().isEmpty()) {
            return "EMPTY";
        }
        return "ACTIVE";
    }
}
