package com.am.common.amcommondata.domain.asset.cryptocurrency;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.asset.common.*;
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
public class Cryptocurrency extends Asset {
    @NotNull(message = "Crypto info is required")
    @Embedded
    private CryptoInfo cryptoInfo;
    
    @Embedded
    private MarketData marketData;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String transactionHash;
    private String securityMeasures;
    private String backupStatus;
    private String recoveryPhrase;
    private Boolean twoFactorEnabled;
    private String kycStatus;
}
