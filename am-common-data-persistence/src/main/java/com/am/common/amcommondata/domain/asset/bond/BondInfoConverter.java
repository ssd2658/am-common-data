package com.am.common.amcommondata.domain.asset.bond;


import com.am.common.amcommondata.domain.common.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter(autoApply = true)
public class BondInfoConverter implements AttributeConverter<BondInfo, String> {
    private static final Logger logger = LoggerFactory.getLogger(BondInfoConverter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BondInfo bondInfo) {
        try {
            return objectMapper.writeValueAsString(bondInfo);
        } catch (Exception e) {
            logger.error("Error converting BondInfo to JSON", e);
            return null;
        }
    }

    @Override
    public BondInfo convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, BondInfo.class);
        } catch (Exception e) {
            logger.error("Error converting JSON to BondInfo", e);
            return null;
        }
    }
}
