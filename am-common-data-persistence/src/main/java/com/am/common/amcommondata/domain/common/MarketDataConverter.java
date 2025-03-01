package com.am.common.amcommondata.domain.common;

import com.am.common.amcommondata.domain.enums.TimeFrame;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter(autoApply = true)
public class MarketDataConverter implements AttributeConverter<MarketData, String> {
    private static final Logger logger = LoggerFactory.getLogger(MarketDataConverter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(MarketData marketData) {
        try {
            return objectMapper.writeValueAsString(marketData);
        } catch (Exception e) {
            logger.error("Error converting MarketData to JSON", e);
            return null;
        }
    }

    @Override
    public MarketData convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, MarketData.class);
        } catch (Exception e) {
            logger.error("Error converting JSON to MarketData", e);
            return null;
        }
    }
}
