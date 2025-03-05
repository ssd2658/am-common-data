package com.am.common.amcommondata.domain.asset.equity.embedded;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class CompanyInfo {
    private String isin;
    private String symbol;
    private String companyName;
    private String country;
    private String currency;
    private Double faceValue;
    private String exchange;
    private String sector;
    private String industry;
    private String companyDescription;
    private String website;
}
