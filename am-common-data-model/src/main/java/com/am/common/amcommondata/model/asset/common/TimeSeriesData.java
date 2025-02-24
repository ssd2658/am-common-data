package com.am.common.amcommondata.model.asset.common;

import com.am.common.amcommondata.model.enums.TimeFrame;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeSeriesData {
    private LocalDateTime timestamp;
    private TimeFrame timeFrame;
    private Map<TimeFrame, List<OHLCV>> timeFrameData = new HashMap<>();
    private OHLCV latestFiveMin;
    private OHLCV latestFifteenMin;
    private OHLCV latestHourly;
    private OHLCV latestDaily;
    private OHLCV latestWeekly;
    private OHLCV latestMonthly;
    private OHLCV latestYearly;
}
