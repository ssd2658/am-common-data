package com.am.common.amcommondata.domain.asset.equity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class FundamentalData {
    private Double peRatio;
    private Double pbRatio;
    private Double eps;
    private Double dividendYield;
    private String dividendPaymentFrequency;
    private String financialYearEnd;
}
