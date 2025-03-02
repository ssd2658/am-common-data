package com.am.common.amcommondata.domain.common;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

import com.am.common.amcommondata.model.enums.TimeFrame;

import java.util.List;
import java.util.HashMap;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TimeSeriesData {
    private LocalDateTime timestamp;
    private TimeFrame timeFrame;
    
    @ElementCollection(fetch = FetchType.LAZY)
    private Map<TimeFrame, List<OHLCV>> timeFrameData = new HashMap<>();
    
    private OHLCV latestFiveMin;
    private OHLCV latestFifteenMin;
    private OHLCV latestHourly;
    private OHLCV latestDaily;
    private OHLCV latestWeekly;
    private OHLCV latestMonthly;
    private OHLCV latestYearly;
}
