package com.am.common.amcommondata.domain.enums;

public enum BrokerType {
    DHAN("Dhan"),
    ZERODHA("Zerodha"),
    MSTOCK("MStock"),
    GROW("Grow"),
    KOTAK("Kotak");
    
    private String brokerName;
        
    BrokerType(String brokerName) {
        this.brokerName = brokerName;
    }

    public static BrokerType fromCode(String code) {
        for (BrokerType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String getCode() {
        return brokerName;
    }
}
