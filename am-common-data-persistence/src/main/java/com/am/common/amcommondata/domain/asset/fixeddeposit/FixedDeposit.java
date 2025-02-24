package com.am.common.amcommondata.domain.asset.fixeddeposit;

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
public class FixedDeposit extends Asset {
    @NotNull(message = "Deposit info is required")
    @Embedded
    private DepositInfo depositInfo;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String bankName;
    private String depositScheme;
    private String depositStatus; // Active, Matured, Closed
    private String linkedBankAccount;
    private Boolean isTaxSaving;
    private String form15GHSubmitted;
}
