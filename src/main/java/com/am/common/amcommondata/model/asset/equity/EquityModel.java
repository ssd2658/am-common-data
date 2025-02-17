package com.am.common.amcommondata.model.asset.equity;

import com.am.common.amcommondata.model.asset.AssetModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class EquityModel extends AssetModel {
    private String companyName;
    private String sector;
    private String industry;
    private Double marketCap;
    private String exchange;
    private Double peRatio;
    private Double pbRatio;
    private Double dividendYield;
    private Double eps;
    private Integer sharesOutstanding;
    private String stockType; // Common, Preferred
    private String isin;
    private String countryOfIncorporation;
}
