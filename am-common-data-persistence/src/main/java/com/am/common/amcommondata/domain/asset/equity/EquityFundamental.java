package com.am.common.amcommondata.domain.asset.equity;

import com.am.common.amcommondata.domain.asset.equity.embedded.*;
import com.am.common.amcommondata.domain.common.AuditInfo;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equity_fundamental")
public class EquityFundamental {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equity_id", nullable = false)
    private EquityInfo equity;

    @Embedded
    private AuditInfo auditInfo;

    // Market Cap and Classification
    @Column(name = "market_cap", precision = 19, scale = 2)
    private BigDecimal marketCap;

    @Enumerated(EnumType.STRING)
    @Column(name = "cap_category", length = 20)
    private CapCategory capCategory;

    // Valuation Metrics
    @Embedded
    private ValuationMetrics valuationMetrics;

    // Financial Ratios
    @Embedded
    private FinancialRatios financialRatios;

    // Growth Metrics
    @Embedded
    private GrowthMetrics growthMetrics;

    public enum CapCategory {
        LARGE_CAP,
        MID_CAP,
        SMALL_CAP;

        public static CapCategory fromMarketCap(BigDecimal marketCap) {
            if (marketCap == null) return null;
            
            // These thresholds can be configured based on your market's definition
            BigDecimal largeCap = new BigDecimal("20000000000"); // 20B
            BigDecimal midCap = new BigDecimal("2000000000");   // 2B

            if (marketCap.compareTo(largeCap) >= 0) {
                return LARGE_CAP;
            } else if (marketCap.compareTo(midCap) >= 0) {
                return MID_CAP;
            } else {
                return SMALL_CAP;
            }
        }
    }
}
