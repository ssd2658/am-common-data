package com.am.common.amcommondata.model;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import com.am.common.amcommondata.model.asset.AssetModel;

@Data
@Builder
public class PortfolioModel {
    private Long id;
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

    @Builder.Default
    private Set<String> assetTypes = new HashSet<>();
}
