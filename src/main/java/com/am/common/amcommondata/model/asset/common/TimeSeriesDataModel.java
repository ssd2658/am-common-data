package com.am.common.amcommondata.model.asset.common;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;

@Data
@Builder
public class TimeSeriesDataModel {
    private Long id;
    private LocalDateTime timestamp;
    private String timeframe;
    private OHLCVModel ohlcv;
    private Double volume;
    private Double openInterest;
    private Double volatility;
    private Double relativeStrengthIndex;
    private Double movingAverage50;
    private Double movingAverage200;
    private Double bollingerUpperBand;
    private Double bollingerLowerBand;
    private Double macdLine;
    private Double macdSignalLine;
    private Double macdHistogram;
}
