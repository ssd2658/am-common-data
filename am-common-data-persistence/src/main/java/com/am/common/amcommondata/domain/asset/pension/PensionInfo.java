package com.am.common.amcommondata.domain.asset.pension;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class PensionInfo {
    private String schemeType; // Tier 1, Tier 2
    private String pensionFundManager;
    private String assetAllocation;
    private Double employerContribution;
    private Double employeeContribution;
    private String withdrawalRules;
    private Integer lockInPeriod;
    private String nomineeDetails;
    private Boolean autoChoice;
    private String activeChoice;
    private Double equityAllocation;
    private Double corporateBondAllocation;
    private Double governmentBondAllocation;
    private Double alternativeAllocation;
    private String annuityProvider;
    private String annuityType;
}
