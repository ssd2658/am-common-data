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
public class VolatilityIndicators {
    @Column(name = "bollinger_upper", precision = 10, scale = 2)
    private BigDecimal bollingerUpper;

    @Column(name = "bollinger_middle", precision = 10, scale = 2)
    private BigDecimal bollingerMiddle;

    @Column(name = "bollinger_lower", precision = 10, scale = 2)
    private BigDecimal bollingerLower;

    @Column(name = "atr", precision = 10, scale = 2)
    private BigDecimal atr;
}
