package com.am.common.amcommondata.domain.asset.mutualfund;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.asset.common.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MutualFund extends Asset {
    @NotBlank(message = "Fund symbol is required")
    private String symbol;
    
    @Embedded
    private FundInfo fundInfo;
    
    @Embedded
    private MarketData marketData;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String folioNumber;
    private String registrarName;
    private String distributorCode;
    private Boolean directPlan;
    private String dividendOption; // Reinvestment, Payout
}
