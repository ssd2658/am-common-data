package com.am.common.amcommondata.domain.exchange;

public enum IndexType {
    BROAD_MARKET("Broad Market"), // e.g., NIFTY 50, SENSEX
    SECTORAL("Sectoral"), // e.g., NIFTY Bank, NIFTY IT
    THEMATIC("Thematic"), // e.g., NIFTY Infrastructure
    STRATEGY("Strategy"), // e.g., NIFTY Quality 30
    MARKET_CAP("Market Cap"), // e.g., NIFTY Midcap 100
    FIXED_INCOME("Fixed Income"), // e.g., NIFTY Corporate Bond
    ESG("ESG"), // Environmental, Social, and Governance
    VOLATILITY("Volatility"), // e.g., India VIX
    DERIVATIVE("Derivative"), // Futures and Options
    GLOBAL("Global"); // International indices

    private final String description;

    IndexType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
