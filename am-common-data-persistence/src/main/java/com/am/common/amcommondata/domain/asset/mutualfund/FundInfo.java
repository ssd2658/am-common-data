package com.am.common.amcommondata.domain.asset.mutualfund;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class FundInfo {
    private String fundCategory; // Equity, Debt, Hybrid, etc.
    private String fundType; // Open-ended, Close-ended
    private String fundStyle; // Large Cap, Mid Cap, Small Cap, etc.
    private String fundManager;
    private String fundHouse;
    private Double aum;
    private Double expenseRatio;
    private Double exitLoad;
    private String benchmark;
    private Double benchmarkReturn;
    private String investmentStrategy;
    private Integer minInvestmentAmount;
    private String sipOption;
    private String redemptionPeriod;
    private String fundRating;
    private String ratingAgency;
}
