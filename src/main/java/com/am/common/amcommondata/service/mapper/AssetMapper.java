package com.am.common.amcommondata.service.mapper;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.asset.AssetModel;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AssetMapper {
    private final MarketDataMapper marketDataMapper;

    public AssetModel toModel(Asset entity) {
        if (entity == null) {
            return null;
        }

        return AssetModel.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .name(entity.getName())
                .description(entity.getDescription())
                .assetType(entity.getAssetType())
                //.marketData(marketDataMapper.toModel(entity.getMarketData()))
                //.currentValue(calculateCurrentValue(entity))
                .investmentValue(calculateInvestmentValue(entity))
                .profitLoss(calculateProfitLoss(entity))
                .profitLossPercentage(calculateProfitLossPercentage(entity))
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isActive(entity.isActive())
                .build();
    }

    // private Double calculateCurrentValue(Asset asset) {
    //     if (asset.getMarketData() == null || asset.getMarketData().getMarketPrice() == null) {
    //         return 0.0;
    //     }
    //     return asset.getMarketData().getMarketPrice();
    // }

    private Double calculateInvestmentValue(Asset asset) {
        // Implementation depends on your business logic
        return 0.0;
    }

    private Double calculateProfitLoss(Asset asset) {
        //Double currentValue = calculateCurrentValue(asset);
        Double investmentValue = calculateInvestmentValue(asset);
        //return currentValue - investmentValue;
        return 0.0;
    }

    private Double calculateProfitLossPercentage(Asset asset) {
        Double profitLoss = calculateProfitLoss(asset);
        Double investmentValue = calculateInvestmentValue(asset);
        if (investmentValue == 0) {
            return 0.0;
        }
        return (profitLoss / investmentValue) * 100;
    }
}
