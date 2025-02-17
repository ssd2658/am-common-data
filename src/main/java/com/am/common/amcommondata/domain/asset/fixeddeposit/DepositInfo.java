package com.am.common.amcommondata.domain.asset.fixeddeposit;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class DepositInfo {
    private String depositType; // Regular, Tax Saving, Special
    private Double interestRate;
    private String interestPayoutFrequency; // Monthly, Quarterly, Annual, At Maturity
    private LocalDate startDate;
    private LocalDate maturityDate;
    private Integer tenureInMonths;
    private Boolean autoRenewal;
    private String renewalInstructions;
    private Boolean nominationRegistered;
    private String nomineeDetails;
    private String bankBranch;
    private String accountNumber;
    private String depositNumber;
    private Double maturityAmount;
    private String interestCompounding; // Monthly, Quarterly, Half-Yearly, Yearly
    private Boolean prematureWithdrawalAllowed;
    private Double prematureWithdrawalPenalty;
}
