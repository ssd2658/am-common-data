package com.am.common.amcommondata.domain.asset.pension;

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
public class NPS extends Asset {
    @NotBlank(message = "PRAN is required")
    private String pran;
    
    @Embedded
    private PensionInfo pensionInfo;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String subscriberType; // Government, Corporate, All Citizens
    private String accountType; // Tier I, Tier II
    private String kycStatus;
    private String nominationRegistered;
    private String lastContributionDate;
}
