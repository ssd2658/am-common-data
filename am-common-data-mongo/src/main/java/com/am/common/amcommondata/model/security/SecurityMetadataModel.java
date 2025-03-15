package com.am.common.amcommondata.model.security;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityMetadataModel {
    private String sector;
    private String industry;
    private Long marketCapValue;
    private String capCategory;
    private String securityType;
    private String exchange;
    private String countryOfIncorporation;
    private LocalDateTime listingDate;
    private LocalDateTime delistingDate;
    private String tradingStatus;
    private Map<String, Object> customAttributes;
}
