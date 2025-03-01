package com.am.common.amcommondata.domain.common;

import com.am.common.amcommondata.domain.enums.TimeFrame;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter(autoApply = true)
public class InvestmentDetailsConverter implements AttributeConverter<InvestmentDetails, String> {
    private static final Logger logger = LoggerFactory.getLogger(InvestmentDetailsConverter.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(InvestmentDetails investmentDetails) {
        try {
            return objectMapper.writeValueAsString(investmentDetails);
        } catch (Exception e) {
            logger.error("Error converting InvestmentDetails to JSON", e);
            return null;
        }
    }

    @Override
    public InvestmentDetails convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, InvestmentDetails.class);
        } catch (Exception e) {
            logger.error("Error converting JSON to InvestmentDetails", e);
            return null;
        }
    }
}
