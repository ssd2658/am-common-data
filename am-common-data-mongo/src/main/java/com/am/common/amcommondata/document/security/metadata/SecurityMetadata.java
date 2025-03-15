package com.am.common.amcommondata.document.security.metadata;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityMetadata {
    
    @Field("sector")
    private String sector;
    
    @Field("industry")
    private String industry;
    
    @Field("market_cap_value")
    private Long marketCapValue;
    
    @Field("cap_category")
    private String capCategory;
    
    @Field("security_type")
    private String securityType;
    
    @Field("exchange")
    private String exchange;
    
    @Field("country_of_incorporation")
    private String countryOfIncorporation;
    
    @Field("listing_date")
    private LocalDateTime listingDate;
    
    @Field("delisting_date")
    private LocalDateTime delistingDate;
    
    @Field("trading_status")
    private String tradingStatus;
    
    @Field("custom_attributes")
    private Map<String, Object> customAttributes;
}
