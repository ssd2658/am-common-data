package com.am.common.amcommondata.domain.asset.realestate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class PropertyInfo {
    private String propertyType; // Residential, Commercial, Land
    private String constructionStatus; // Ready, Under Construction
    private Integer yearBuilt;
    private Double builtUpArea;
    private Double carpetArea;
    private String areaUnit;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    private Integer floorNumber;
    private Integer totalFloors;
    private Boolean furnished;
    private String furnishingDetails;
    private String amenities;
    private String parkingType;
    private Integer parkingSpaces;
    private String waterSupply;
    private String powerBackup;
    private String maintenanceStatus;
}
