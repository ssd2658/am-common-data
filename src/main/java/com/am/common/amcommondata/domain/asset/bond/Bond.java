package com.am.common.amcommondata.domain.asset.bond;

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
public class Bond extends Asset {
    @NotNull(message = "Bond info is required")
    @Embedded
    private BondInfo bondInfo;
    
    @Embedded
    private MarketData marketData;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String certificateNumber;
    private String depositoryParticipant;
    private String dematAccount;
    private String registrarName;
    private Boolean interestTaxable;
    private String form15GHSubmitted;
}
