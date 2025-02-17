package com.am.common.amcommondata.domain.asset.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class MarketData {
    @ElementCollection
    @CollectionTable(name = "time_series_data")
    @OrderBy("timestamp DESC")
    private List<TimeSeriesData> timeSeriesData = new ArrayList<>();

    @Embedded
    private OHLCV latestOHLCV;

    private Double marketPrice;
    private Double dayHigh;
    private Double dayLow;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekLow;
    private Double previousClose;
    private Long volume;
    private Double marketCap;
    private String marketCapCategory;
    private Double priceInHomeCurrency;
    
    // Market Indicators
    private Double relativeStrengthIndex;
    private Double movingAverage50;
    private Double movingAverage200;
    private Double averageVolume30Days;
    private Double beta;
    private Double volatility30Days;
    
    // Order Book
    private Double bidPrice;
    private Double askPrice;
    private Long bidSize;
    private Long askSize;
    private Double spreadPercentage;
}
