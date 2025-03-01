package com.am.common.amcommondata.domain.asset.gold;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.common.*;
import com.am.common.amcommondata.domain.common.InvestmentDetails;
import com.am.common.amcommondata.domain.common.TaxInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Gold extends Asset {
    @NotNull(message = "Gold info is required")
    @Embedded
    private GoldInfo goldInfo;
    
    @Embedded
    private MarketData marketData;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String dealerName;
    private String purchaseInvoiceNumber;
    private String custodialAccount;
    private String vaultLocation;
}
