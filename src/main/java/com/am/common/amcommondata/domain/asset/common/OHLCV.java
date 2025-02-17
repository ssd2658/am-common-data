package com.am.common.amcommondata.domain.asset.common;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OHLCV {
    @NotNull
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @NotNull
    @Column(name = "open_price")
    private Double open;

    @NotNull
    @Column(name = "high_price")
    private Double high;

    @NotNull
    @Column(name = "low_price")
    private Double low;

    @NotNull
    @Column(name = "close_price")
    private Double close;

    @NotNull
    @Column(name = "volume")
    private Long volume;

    @Column(name = "vwap")
    private Double vwap;

    @Column(name = "number_of_trades")
    private Long numberOfTrades;

    @Column(name = "turnover")
    private Double turnover;
}
