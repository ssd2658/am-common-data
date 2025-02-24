package com.am.common.amcommondata.domain.asset.commodity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class CommodityInfo {
    private String commodityType; // Physical, Future, ETF
    private String grade;
    private String unit;
    private Double purity;
    private String storageLocation;
    private String custodian;
    private String deliveryMethod;
    private String contractSize;
    private String expiryDate;
    private Boolean isDeliverable;
}
