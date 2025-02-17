package com.am.common.amcommondata.domain.asset.equity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class CompanyInfo {
    private String companyName;
    private String sector;
    private String industry;
    private String isin;
    private String companyDescription;
    private String headquartersCountry;
    private String website;
}
