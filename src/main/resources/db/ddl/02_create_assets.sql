-- Create base Assets table
CREATE TABLE assets (
    id UUID PRIMARY KEY,
    symbol VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    portfolio_id UUID,
    asset_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    version BIGINT DEFAULT 0,
    FOREIGN KEY (portfolio_id) REFERENCES portfolios(id)
);

-- Create Equity table
CREATE TABLE equities (
    id UUID PRIMARY KEY,
    exchange VARCHAR(50),
    sector VARCHAR(100),
    industry VARCHAR(100),
    market_cap DECIMAL(20,2),
    pe_ratio DECIMAL(10,2),
    dividend_yield DECIMAL(5,2),
    beta DECIMAL(5,2),
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create Mutual Fund table
CREATE TABLE mutual_funds (
    id UUID PRIMARY KEY,
    fund_house VARCHAR(255),
    fund_category VARCHAR(100),
    fund_type VARCHAR(50),
    nav DECIMAL(10,2),
    aum DECIMAL(20,2),
    expense_ratio DECIMAL(5,2),
    min_investment DECIMAL(10,2),
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create Bond table
CREATE TABLE bonds (
    id UUID PRIMARY KEY,
    issuer VARCHAR(255),
    bond_type VARCHAR(50),
    face_value DECIMAL(20,2),
    coupon_rate DECIMAL(5,2),
    yield_to_maturity DECIMAL(5,2),
    maturity_date DATE,
    credit_rating VARCHAR(10),
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create Cryptocurrency table
CREATE TABLE cryptocurrencies (
    id UUID PRIMARY KEY,
    blockchain VARCHAR(100),
    token_type VARCHAR(50),
    max_supply DECIMAL(20,8),
    circulating_supply DECIMAL(20,8),
    market_cap_rank INTEGER,
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create Gold table
CREATE TABLE gold (
    id UUID PRIMARY KEY,
    purity DECIMAL(5,2),
    weight DECIMAL(10,3),
    form VARCHAR(50),
    dealer_name VARCHAR(255),
    purchase_invoice_number VARCHAR(100),
    custodial_account VARCHAR(100),
    vault_location VARCHAR(255),
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create Fixed Deposit table
CREATE TABLE fixed_deposits (
    id UUID PRIMARY KEY,
    bank_name VARCHAR(255),
    account_number VARCHAR(100),
    interest_rate DECIMAL(5,2),
    maturity_date DATE,
    deposit_type VARCHAR(50),
    auto_renewal BOOLEAN,
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create Real Estate table
CREATE TABLE real_estate (
    id UUID PRIMARY KEY,
    property_type VARCHAR(50),
    location VARCHAR(255),
    area_sqft DECIMAL(10,2),
    registration_number VARCHAR(100),
    rental_yield DECIMAL(5,2),
    occupancy_status VARCHAR(50),
    FOREIGN KEY (id) REFERENCES assets(id)
);

-- Create NPS table
CREATE TABLE nps (
    id UUID PRIMARY KEY,
    pran_number VARCHAR(100),
    scheme_preference VARCHAR(50),
    equity_allocation DECIMAL(5,2),
    debt_allocation DECIMAL(5,2),
    govt_securities_allocation DECIMAL(5,2),
    tier_type VARCHAR(10),
    FOREIGN KEY (id) REFERENCES assets(id)
);
