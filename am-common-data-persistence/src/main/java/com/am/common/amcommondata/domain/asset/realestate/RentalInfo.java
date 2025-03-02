package com.am.common.amcommondata.domain.asset.realestate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class RentalInfo {
    private Boolean isRented;
    private Double monthlyRent;
    private Double securityDeposit;
    private String tenantName;
    private String leaseStartDate;
    private String leaseEndDate;
    private String rentPaymentDate;
    private String rentEscalationTerms;
    private Double maintenanceCharges;
    private String maintenanceIncluded;
    private Double propertyTax;
    private Double insurancePremium;
    private Double annualAppreciation;
}
