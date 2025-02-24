package com.am.common.amcommondata.domain.asset.bond;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.asset.bond.BondInfo;
import com.am.common.amcommondata.model.asset.common.InvestmentDetails;
import com.am.common.amcommondata.model.asset.common.MarketData;
import com.am.common.amcommondata.model.asset.common.TaxInfo;
import com.am.common.amcommondata.domain.asset.common.InvestmentDetailsConverter;
import com.am.common.amcommondata.domain.asset.common.MarketDataConverter;
import com.am.common.amcommondata.domain.asset.common.TaxInfoConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Bond extends Asset {
    
    @NotNull(message = "Bond info is required")
    @Convert(converter = BondInfoConverter.class)
    @Column(name = "bond_info", columnDefinition = "jsonb")
    private BondInfo bondInfo;
    
    @Convert(converter = MarketDataConverter.class)
    @Column(name = "market_data", columnDefinition = "jsonb")
    private MarketData marketData;
    
    @Convert(converter = InvestmentDetailsConverter.class)
    @Column(name = "investment_details", columnDefinition = "jsonb")
    private InvestmentDetails investmentDetails;
    
    @Convert(converter = TaxInfoConverter.class)
    @Column(name = "tax_info", columnDefinition = "jsonb")
    private TaxInfo taxInfo;
    
    private String certificateNumber;
    private String depositoryParticipant;
    private String dematAccount;
    private String registrarName;
    private Boolean interestTaxable;
    private String form15GHSubmitted;
}
