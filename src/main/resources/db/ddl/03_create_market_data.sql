-- Create Market Data tables
CREATE TABLE market_data (
    asset_id UUID PRIMARY KEY,
    market_price DECIMAL(20,8),
    day_high DECIMAL(20,8),
    day_low DECIMAL(20,8),
    fifty_two_week_high DECIMAL(20,8),
    fifty_two_week_low DECIMAL(20,8),
    previous_close DECIMAL(20,8),
    volume BIGINT,
    market_cap DECIMAL(20,2),
    market_cap_category VARCHAR(50),
    price_in_home_currency DECIMAL(20,2),
    relative_strength_index DECIMAL(10,2),
    moving_average_50 DECIMAL(20,8),
    moving_average_200 DECIMAL(20,8),
    average_volume_30_days BIGINT,
    beta DECIMAL(5,2),
    volatility_30_days DECIMAL(5,2),
    bid_price DECIMAL(20,8),
    ask_price DECIMAL(20,8),
    bid_size BIGINT,
    ask_size BIGINT,
    spread_percentage DECIMAL(5,2),
    FOREIGN KEY (asset_id) REFERENCES assets(id)
);

-- Create OHLCV table for time series data
CREATE TABLE ohlcv_data (
    id UUID PRIMARY KEY,
    asset_id UUID,
    timestamp TIMESTAMP,
    timeframe VARCHAR(20),
    open_price DECIMAL(20,8),
    high_price DECIMAL(20,8),
    low_price DECIMAL(20,8),
    close_price DECIMAL(20,8),
    volume BIGINT,
    vwap DECIMAL(20,8),
    number_of_trades BIGINT,
    turnover DECIMAL(20,2),
    FOREIGN KEY (asset_id) REFERENCES assets(id)
);
