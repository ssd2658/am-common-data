package com.am.common.amcommondata.domain.asset.equity.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class GrowthMetrics {
    @Column(name = "revenue_growth_yoy", precision = 10, scale = 2)
    private BigDecimal revenueGrowthYoY;

    @Column(name = "profit_growth_yoy", precision = 10, scale = 2)
    private BigDecimal profitGrowthYoY;

    @Column(name = "asset_growth_yoy", precision = 10, scale = 2)
    private BigDecimal assetGrowthYoY;
}
