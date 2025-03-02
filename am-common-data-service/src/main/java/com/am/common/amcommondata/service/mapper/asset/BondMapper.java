package com.am.common.amcommondata.service.mapper.asset;

import com.am.common.amcommondata.domain.asset.bond.Bond;
import com.am.common.amcommondata.domain.common.BondInfo;
import com.am.common.amcommondata.model.asset.bond.BondModel;
import com.am.common.amcommondata.service.mapper.MarketDataMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.AfterMapping;

@Mapper(componentModel = "spring", 
        uses = {MarketDataMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BondMapper {

    @Mapping(target = "bondInfo", ignore = true)
    Bond toEntity(BondModel model);
    
    @Mapping(target = "bondType", source = "bondInfo.bondType")
    @Mapping(target = "issuer", source = "bondInfo.issuer")
    @Mapping(target = "faceValue", source = "bondInfo.faceValue")
    @Mapping(target = "couponRate", source = "bondInfo.couponRate")
    @Mapping(target = "couponFrequency", source = "bondInfo.couponFrequency")
    @Mapping(target = "creditRating", source = "bondInfo.creditRating")
    @Mapping(target = "yieldToMaturity", source = "bondInfo.yieldToMaturity")
    @Mapping(target = "isCallable", source = "bondInfo.callable")
    BondModel toModel(Bond entity);
    
    @Mapping(target = "bondInfo", ignore = true)
    Bond updateEntity(@MappingTarget Bond entity, BondModel model);

    @AfterMapping
    default void afterToEntity(BondModel model, @MappingTarget Bond entity) {
        BondInfo bondInfo = BondInfo.builder()
                .bondType(model.getBondType())
                .issuer(model.getIssuer())
                .faceValue(model.getFaceValue())
                .couponRate(model.getCouponRate())
                .couponFrequency(model.getCouponFrequency())
                .creditRating(model.getCreditRating())
                .yieldToMaturity(model.getYieldToMaturity())
                .callable(model.getIsCallable())
                .build();
        entity.setBondInfo(bondInfo);
    }

    @AfterMapping
    default void afterUpdateEntity(BondModel model, @MappingTarget Bond entity) {
        if (entity.getBondInfo() == null) {
            entity.setBondInfo(new BondInfo());
        }
        
        BondInfo bondInfo = entity.getBondInfo();
        bondInfo.setBondType(model.getBondType());
        bondInfo.setIssuer(model.getIssuer());
        bondInfo.setFaceValue(model.getFaceValue());
        bondInfo.setCouponRate(model.getCouponRate());
        bondInfo.setCouponFrequency(model.getCouponFrequency());
        bondInfo.setCreditRating(model.getCreditRating());
        bondInfo.setYieldToMaturity(model.getYieldToMaturity());
        bondInfo.setCallable(model.getIsCallable());
    }
}
