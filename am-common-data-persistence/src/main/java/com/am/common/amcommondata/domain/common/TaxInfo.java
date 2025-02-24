package com.am.common.amcommondata.domain.asset.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class TaxInfo {
    private Double capitalGainsTaxRate;
    private Double dividendTaxRate;
    private String regulatoryBody;
    private Boolean qualifiedForTaxTreaty;
    private String taxJurisdiction;
    private String taxLotMethod; // FIFO, LIFO, etc.
}
