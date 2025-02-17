package com.am.common.amcommondata.domain.asset.common;

import com.am.common.amcommondata.domain.enums.TimeFrame;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@Data
@Embeddable
@Builder
@AllArgsConstructor
public class TimeSeriesData {
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    private Map<TimeFrame, List<OHLCV>> timeFrameData;
    
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
    
    public TimeSeriesData() {
        this.timeFrameData = new HashMap<>();
    }
    
    public void addDataPoint(TimeFrame timeFrame, OHLCV data) {
        timeFrameData.computeIfAbsent(timeFrame, k -> new ArrayList<>()).add(data);
        updateLatestData(timeFrame, data);
    }
    
    private void updateLatestData(TimeFrame timeFrame, OHLCV data) {
        switch (timeFrame) {
            case FIVE_MINUTES:
                this.latestFiveMin = data;
                break;
            case FIFTEEN_MINUTES:
                this.latestFifteenMin = data;
                break;
            case ONE_HOUR:
                this.latestHourly = data;
                break;
            case DAILY:
                this.latestDaily = data;
                break;
            case WEEKLY:
                this.latestWeekly = data;
                break;
            case MONTHLY:
                this.latestMonthly = data;
                break;
            case YEARLY:
                this.latestYearly = data;
                break;
        }
    }
    
    public List<OHLCV> getTimeFrameData(TimeFrame timeFrame) {
        return timeFrameData.getOrDefault(timeFrame, new ArrayList<>());
    }
    
    public OHLCV getLatestData(TimeFrame timeFrame) {
        switch (timeFrame) {
            case FIVE_MINUTES:
                return latestFiveMin;
            case FIFTEEN_MINUTES:
                return latestFifteenMin;
            case ONE_HOUR:
                return latestHourly;
            case DAILY:
                return latestDaily;
            case WEEKLY:
                return latestWeekly;
            case MONTHLY:
                return latestMonthly;
            case YEARLY:
                return latestYearly;
            default:
                return null;
        }
    }
}
