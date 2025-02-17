package com.am.common.amcommondata.model.asset.common;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;

@Data
@Builder
public class OHLCVModel {
    private Long id;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private LocalDateTime timestamp;
    private String timeframe;
    private Double adjustedClose;
    private Double dividendAmount;
    private Double splitCoefficient;
}
