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
public class TechnicalIndicators {
    @Column(name = "rsi_14", precision = 10, scale = 2)
    private BigDecimal rsi14;

    @Column(name = "macd", precision = 10, scale = 2)
    private BigDecimal macd;

    @Column(name = "macd_signal", precision = 10, scale = 2)
    private BigDecimal macdSignal;

    @Column(name = "macd_histogram", precision = 10, scale = 2)
    private BigDecimal macdHistogram;

    @Column(name = "bollinger_upper", precision = 10, scale = 2)
    private BigDecimal bollingerUpper;

    @Column(name = "bollinger_middle", precision = 10, scale = 2)
    private BigDecimal bollingerMiddle;

    @Column(name = "bollinger_lower", precision = 10, scale = 2)
    private BigDecimal bollingerLower;

    @Column(name = "atr", precision = 10, scale = 2)
    private BigDecimal atr;
}
