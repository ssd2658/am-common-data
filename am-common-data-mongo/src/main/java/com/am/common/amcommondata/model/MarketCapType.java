package com.am.common.amcommondata.model;

public enum MarketCapType {
    LARGE_CAP(1000000000000D), // > 1 lakh crore
    MID_CAP(250000000000D),    // 25k to 1 lakh crore
    SMALL_CAP(50000000000D),   // 5k to 25k crore
    MICRO_CAP(0D);      // < 5k crore

    private final double minMarketCapInCrores;

    MarketCapType(double minMarketCapInCrores) {
        this.minMarketCapInCrores = minMarketCapInCrores;
    }

    public static MarketCapType fromMarketCap(double marketCapInCrores) {
        if (marketCapInCrores >= LARGE_CAP.minMarketCapInCrores) {
            return LARGE_CAP;
        } else if (marketCapInCrores >= MID_CAP.minMarketCapInCrores) {
            return MID_CAP;
        } else if (marketCapInCrores >= SMALL_CAP.minMarketCapInCrores) {
            return SMALL_CAP;
        } else {
            return MICRO_CAP;
        }
    }
}

