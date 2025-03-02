package com.am.common.amcommondata.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.HashSet;

import com.am.common.amcommondata.model.asset.AssetModel;
import com.am.common.amcommondata.model.enums.FundType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PortfolioModel {
    private UUID id;
    private String name;
    private String description;
    private Set<AssetModel> assets;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private Double totalValue;
    private Integer assetCount;
    private String status;
    private FundType fundType;

    @Builder.Default
    private Set<String> assetTypes = new HashSet<>();
}
