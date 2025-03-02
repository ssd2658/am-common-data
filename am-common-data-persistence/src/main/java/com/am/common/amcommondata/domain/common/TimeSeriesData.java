package com.am.common.amcommondata.domain.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
import com.am.common.amcommondata.model.enums.TimeFrame;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time_series_data")
public class TimeSeriesData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime timestamp;
    
    @Enumerated(EnumType.STRING)
    private TimeFrame timeFrame;
    
    @ElementCollection(fetch = FetchType.LAZY)
    private Map<TimeFrame, List<OHLCV>> timeFrameData = new HashMap<>();
    
    @Embedded
    private OHLCV latestFiveMin;
    
    @Embedded
    private OHLCV latestFifteenMin;
    
    @Embedded
    private OHLCV latestHourly;
    
    @Embedded
    private OHLCV latestDaily;
    
    @Embedded
    private OHLCV latestWeekly;
    
    @Embedded
    private OHLCV latestMonthly;
    
    @Embedded
    private OHLCV latestYearly;
}
