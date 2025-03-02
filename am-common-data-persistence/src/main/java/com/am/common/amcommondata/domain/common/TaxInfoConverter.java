package com.am.common.amcommondata.domain.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter(autoApply = true)
public class TaxInfoConverter implements AttributeConverter<TaxInfo, String> {
    private static final Logger logger = LoggerFactory.getLogger(TaxInfoConverter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(TaxInfo taxInfo) {
        try {
            return objectMapper.writeValueAsString(taxInfo);
        } catch (Exception e) {
            logger.error("Error converting TaxInfo to JSON", e);
            return null;
        }
    }

    @Override
    public TaxInfo convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, TaxInfo.class);
        } catch (Exception e) {
            logger.error("Error converting JSON to TaxInfo", e);
            return null;
        }
    }
}
