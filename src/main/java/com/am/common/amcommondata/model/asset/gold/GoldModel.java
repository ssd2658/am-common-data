package com.am.common.amcommondata.model.asset.gold;

import com.am.common.amcommondata.model.asset.AssetModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class GoldModel extends AssetModel {
    private String form; // Physical, Digital, ETF
    private String purity; // 24K, 22K, etc.
    private Double weight;
    private String weightUnit;
    private String hallmark;
    private String storageLocation;
    private String custodian;
    private String certificateNumber;
    private Double makingCharges;
    private Double wastageCharges;
    private String jewellerName;
    private String buybackTerms;
    private String storageCharges;
    private String insuranceDetails;
    private String authentication;
}
