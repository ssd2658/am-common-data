package com.am.common.amcommondata.domain.asset.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class InvestmentDetails {
    private Double quantity;
    private Double investmentAmount;
    private Double currentValue;
    private Double averagePrice;
    private Double averagePriceInHomeCurrency;
    private String investmentGrade;
    private String riskRating;
    private Double returnOnInvestment;
    private Double annualizedReturn;
}
