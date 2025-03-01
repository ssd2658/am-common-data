package com.am.common.amcommondata.domain.asset.realestate;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.common.InvestmentDetails;
import com.am.common.amcommondata.domain.common.LocationInfo;
import com.am.common.amcommondata.domain.common.TaxInfo;

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
public class RealEstate extends Asset {
    @NotBlank(message = "Property ID is required")
    private String propertyId;
    
    @Embedded
    private LocationInfo locationInfo;
    
    @Embedded
    private PropertyInfo propertyInfo;
    
    @Embedded
    private RentalInfo rentalInfo;
    
    @Embedded
    private InvestmentDetails investmentDetails;
    
    @Embedded
    private TaxInfo taxInfo;
    
    private String ownershipType; // Individual, Joint, Company
    private String titleDeedNumber;
    private String registrationNumber;
    private String legalStatus;
    private String encumbranceStatus;
}
