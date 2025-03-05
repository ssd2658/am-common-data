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
public class FinancialRatios {
    @Column(name = "debt_to_equity", precision = 10, scale = 2)
    private BigDecimal debtToEquity;

    @Column(name = "current_ratio", precision = 10, scale = 2)
    private BigDecimal currentRatio;

    @Column(name = "quick_ratio", precision = 10, scale = 2)
    private BigDecimal quickRatio;

    @Column(name = "interest_coverage", precision = 10, scale = 2)
    private BigDecimal interestCoverage;

    @Column(name = "roe", precision = 10, scale = 2)
    private BigDecimal roe;

    @Column(name = "roce", precision = 10, scale = 2)
    private BigDecimal roce;

    @Column(name = "roa", precision = 10, scale = 2)
    private BigDecimal roa;

    @Column(name = "profit_margin", precision = 10, scale = 2)
    private BigDecimal profitMargin;

    @Column(name = "operating_margin", precision = 10, scale = 2)
    private BigDecimal operatingMargin;
}
