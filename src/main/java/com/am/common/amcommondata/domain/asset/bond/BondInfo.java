package com.am.common.amcommondata.domain.asset.bond;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class BondInfo {
    private String bondType; // Government, Corporate, Municipal
    private String issuer;
    private String creditRating;
    private String ratingAgency;
    private Double couponRate;
    private String couponFrequency; // Annual, Semi-Annual, Quarterly
    private LocalDate issueDate;
    private LocalDate maturityDate;
    private Double faceValue;
    private Double yieldToMaturity;
    private Boolean callableOption;
    private LocalDate callDate;
    private Double callPrice;
    private Boolean putOption;
    private LocalDate putDate;
    private Double putPrice;
    private String interestPaymentDates;
    private Boolean secured;
    private String seniority; // Senior, Subordinated
    private String listingStatus;
    private String isinNumber;
}
