package com.am.common.amcommondata.domain.asset.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class LocationInfo {
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private Double latitude;
    private Double longitude;
    private String propertyType;
    private Double area;
    private String areaUnit;
}
