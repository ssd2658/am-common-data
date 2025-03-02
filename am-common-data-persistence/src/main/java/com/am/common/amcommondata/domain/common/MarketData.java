package com.am.common.amcommondata.domain.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "market_data")
public class MarketData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "market_data_id")
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
