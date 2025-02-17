package com.am.common.amcommondata.domain.asset.equity;

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
public class Equity extends Asset {
    @NotBlank(message = "Stock symbol is required")
    private String symbol;
    
    @Embedded
    private CompanyInfo companyInfo;
    
    @Embedded
    private MarketData marketData;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private FundamentalData fundamentalData;
    
    @Embedded
    private TaxInfo taxInfo;
    
    // Corporate Actions
    private String lastSplitDate;
    private String lastSplitRatio;
    private String lastDividendDate;
    private Double lastDividendAmount;
}
