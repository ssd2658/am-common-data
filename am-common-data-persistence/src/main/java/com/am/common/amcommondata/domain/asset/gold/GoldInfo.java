package com.am.common.amcommondata.domain.asset.gold;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class GoldInfo {
    private String form; // Physical, Digital, ETF, Sovereign Bond
    private Double weightInGrams;
    private Double purity; // 24K, 22K etc
    private String hallmarkCertificateNumber;
    private String manufacturer;
    private String serialNumber;
    private String storageLocation;
    private String custodian;
    private Boolean isInsured;
    private String insuranceProvider;
    private String policyNumber;
    private Double insuredValue;
    private String buybackGuarantee;
    private Double buybackRate;
}
