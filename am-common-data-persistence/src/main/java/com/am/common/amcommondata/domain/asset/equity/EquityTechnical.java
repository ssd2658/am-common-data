package com.am.common.amcommondata.domain.asset.equity;

import com.am.common.amcommondata.domain.asset.equity.embedded.*;
import com.am.common.amcommondata.domain.common.AuditInfo;
import com.am.common.amcommondata.domain.common.OHLCV;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equity_technical")
public class EquityTechnical {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equity_id", nullable = false)
    private EquityInfo equity;

    // OHLC and Volume data
    @Embedded
    private OHLCV ohlcv;

    // Moving Averages
    @Embedded
    private MovingAverages movingAverages;

    // Technical Indicators
    @Embedded
    private TechnicalIndicators technicalIndicators;

    // Volatility Indicators
    @Embedded
    private VolatilityIndicators volatilityIndicators;

    @Embedded
    private AuditInfo auditInfo;
}
