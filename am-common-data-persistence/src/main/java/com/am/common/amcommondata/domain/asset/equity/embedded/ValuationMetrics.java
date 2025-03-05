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
public class ValuationMetrics {
    @Column(name = "pe_ratio", precision = 10, scale = 2)
    private BigDecimal peRatio;

    @Column(name = "pb_ratio", precision = 10, scale = 2)
    private BigDecimal pbRatio;

    @Column(name = "eps", precision = 10, scale = 2)
    private BigDecimal eps;

    @Column(name = "book_value", precision = 10, scale = 2)
    private BigDecimal bookValue;

    @Column(name = "dividend_yield", precision = 10, scale = 2)
    private BigDecimal dividendYield;

    @Column(name = "dividend_payout_ratio", precision = 10, scale = 2)
    private BigDecimal dividendPayoutRatio;
}
