package com.am.common.amcommondata.model.asset;

import com.am.common.amcommondata.domain.enums.AssetType;
import com.am.common.amcommondata.model.asset.common.MarketDataModel;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class AssetModel {
    private Long id;
    private String symbol;
    private String name;
    private String description;
    private AssetType assetType;
    private MarketDataModel marketData;
    private Double currentValue;
    private Double investmentValue;
    private Double profitLoss;
    private Double profitLossPercentage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
}
