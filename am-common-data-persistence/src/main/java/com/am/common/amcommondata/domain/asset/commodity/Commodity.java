package com.am.common.amcommondata.domain.asset.commodity;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.common.*;
import com.am.common.amcommondata.domain.common.InvestmentDetails;
import com.am.common.amcommondata.domain.common.TaxInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Embedded;``
import jakarta.validation.constraints.NotBlank;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Commodity extends Asset {
    @NotBlank(message = "Commodity symbol is required")
    private String symbol;
    
    @Embedded
    private CommodityInfo commodityInfo;
    
    @Embedded
    private MarketData marketData;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String category; // Precious Metals, Energy, Agriculture
    private Double globalDemand;
    private Double globalSupply;
    private String seasonality;
    private String mainProducingCountries;
}
