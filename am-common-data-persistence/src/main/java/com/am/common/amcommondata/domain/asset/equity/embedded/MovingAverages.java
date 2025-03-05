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
public class MovingAverages {
    @Column(name = "ma_5_day", precision = 10, scale = 2)
    private BigDecimal ma5Day;

    @Column(name = "ma_20_day", precision = 10, scale = 2)
    private BigDecimal ma20Day;

    @Column(name = "ma_50_day", precision = 10, scale = 2)
    private BigDecimal ma50Day;

    @Column(name = "ma_200_day", precision = 10, scale = 2)
    private BigDecimal ma200Day;
}
