-- Insert base assets
INSERT INTO assets (id, symbol, name, description, portfolio_id, asset_type, created_by) VALUES
-- Equities
('123e4567-e89b-12d3-a456-426614174100', 'AAPL', 'Apple Inc.', 'Technology company that designs and manufactures consumer electronics', '123e4567-e89b-12d3-a456-426614174000', 'EQUITY', 'system'),
('123e4567-e89b-12d3-a456-426614174101', 'MSFT', 'Microsoft Corporation', 'Technology company specializing in software and cloud services', '123e4567-e89b-12d3-a456-426614174000', 'EQUITY', 'system'),
-- Mutual Funds
('123e4567-e89b-12d3-a456-426614174102', 'HDFC123', 'HDFC Top 100 Fund', 'Large-cap mutual fund focusing on top 100 companies', '123e4567-e89b-12d3-a456-426614174001', 'MUTUAL_FUND', 'system'),
('123e4567-e89b-12d3-a456-426614174103', 'ICICI456', 'ICICI Prudential Technology Fund', 'Sector-specific fund focusing on technology companies', '123e4567-e89b-12d3-a456-426614174002', 'MUTUAL_FUND', 'system'),
-- Bonds
('123e4567-e89b-12d3-a456-426614174104', 'GOVT2030', 'Government Bond 2030', '10-year government bond', '123e4567-e89b-12d3-a456-426614174001', 'BOND', 'system'),
('123e4567-e89b-12d3-a456-426614174105', 'CORP2025', 'Corporate Bond 2025', '5-year AAA-rated corporate bond', '123e4567-e89b-12d3-a456-426614174003', 'BOND', 'system'),
-- Cryptocurrencies
('123e4567-e89b-12d3-a456-426614174106', 'BTC', 'Bitcoin', 'Leading cryptocurrency by market cap', '123e4567-e89b-12d3-a456-426614174002', 'CRYPTOCURRENCY', 'system'),
('123e4567-e89b-12d3-a456-426614174107', 'ETH', 'Ethereum', 'Smart contract platform', '123e4567-e89b-12d3-a456-426614174002', 'CRYPTOCURRENCY', 'system'),
-- Gold
('123e4567-e89b-12d3-a456-426614174108', 'GOLD999', 'Gold Bar 999', '24K Gold Bar', '123e4567-e89b-12d3-a456-426614174003', 'GOLD', 'system'),
('123e4567-e89b-12d3-a456-426614174109', 'GOLD995', 'Gold Coin 995', '22K Gold Coin', '123e4567-e89b-12d3-a456-426614174004', 'GOLD', 'system'),
-- Fixed Deposits
('123e4567-e89b-12d3-a456-426614174110', 'FD001', 'HDFC Bank FD', '5-year fixed deposit with quarterly interest', '123e4567-e89b-12d3-a456-426614174001', 'FIXED_DEPOSIT', 'system'),
('123e4567-e89b-12d3-a456-426614174111', 'FD002', 'ICICI Bank FD', '3-year fixed deposit with cumulative interest', '123e4567-e89b-12d3-a456-426614174003', 'FIXED_DEPOSIT', 'system'),
-- Real Estate
('123e4567-e89b-12d3-a456-426614174112', 'PROP001', 'Commercial Property Mumbai', 'Commercial property in prime location', '123e4567-e89b-12d3-a456-426614174000', 'REAL_ESTATE', 'system'),
('123e4567-e89b-12d3-a456-426614174113', 'PROP002', 'Residential Property Bangalore', '3BHK apartment for rental income', '123e4567-e89b-12d3-a456-426614174004', 'REAL_ESTATE', 'system'),
-- NPS
('123e4567-e89b-12d3-a456-426614174114', 'NPS001', 'NPS Tier 1 Account', 'Government pension scheme with tax benefits', '123e4567-e89b-12d3-a456-426614174001', 'NPS', 'system'),
('123e4567-e89b-12d3-a456-426614174115', 'NPS002', 'NPS Tier 2 Account', 'Voluntary contribution account', '123e4567-e89b-12d3-a456-426614174004', 'NPS', 'system');

-- Insert equities details
INSERT INTO equities (id, exchange, sector, industry, market_cap, pe_ratio, dividend_yield, beta) VALUES
('123e4567-e89b-12d3-a456-426614174100', 'NASDAQ', 'Technology', 'Consumer Electronics', 2500000000000.00, 25.5, 0.65, 1.2),
('123e4567-e89b-12d3-a456-426614174101', 'NASDAQ', 'Technology', 'Software', 2000000000000.00, 30.2, 0.85, 1.1);

-- Insert mutual funds details
INSERT INTO mutual_funds (id, fund_house, fund_category, fund_type, nav, aum, expense_ratio, min_investment) VALUES
('123e4567-e89b-12d3-a456-426614174102', 'HDFC Mutual Fund', 'Large Cap', 'Equity', 250.75, 15000000000.00, 1.5, 5000.00),
('123e4567-e89b-12d3-a456-426614174103', 'ICICI Prudential', 'Sectoral', 'Equity', 175.50, 8000000000.00, 1.8, 5000.00);

-- Insert bonds details
INSERT INTO bonds (id, issuer, bond_type, face_value, coupon_rate, yield_to_maturity, maturity_date, credit_rating) VALUES
('123e4567-e89b-12d3-a456-426614174104', 'Government of India', 'GOVERNMENT', 1000000.00, 6.5, 6.8, '2030-12-31', 'AAA'),
('123e4567-e89b-12d3-a456-426614174105', 'HDFC Limited', 'CORPORATE', 500000.00, 7.5, 7.8, '2025-06-30', 'AAA');

-- Insert cryptocurrencies details
INSERT INTO cryptocurrencies (id, blockchain, token_type, max_supply, circulating_supply, market_cap_rank) VALUES
('123e4567-e89b-12d3-a456-426614174106', 'Bitcoin', 'NATIVE', 21000000, 19000000, 1),
('123e4567-e89b-12d3-a456-426614174107', 'Ethereum', 'NATIVE', NULL, 120000000, 2);

-- Insert gold details
INSERT INTO gold (id, purity, weight, form, dealer_name, purchase_invoice_number, custodial_account, vault_location) VALUES
('123e4567-e89b-12d3-a456-426614174108', 99.9, 100.000, 'BAR', 'MMTC-PAMP', 'INV001', 'SAFE001', 'Mumbai Vault'),
('123e4567-e89b-12d3-a456-426614174109', 99.5, 10.000, 'COIN', 'MMTC-PAMP', 'INV002', 'SAFE002', 'Mumbai Vault');

-- Insert fixed deposits details
INSERT INTO fixed_deposits (id, bank_name, account_number, interest_rate, maturity_date, deposit_type, auto_renewal) VALUES
('123e4567-e89b-12d3-a456-426614174110', 'HDFC Bank', 'FD00123456', 7.5, '2026-12-31', 'CUMULATIVE', true),
('123e4567-e89b-12d3-a456-426614174111', 'ICICI Bank', 'FD00789012', 7.25, '2024-12-31', 'NON_CUMULATIVE', false);

-- Insert real estate details
INSERT INTO real_estate (id, property_type, location, area_sqft, registration_number, rental_yield, occupancy_status) VALUES
('123e4567-e89b-12d3-a456-426614174112', 'COMMERCIAL', 'Mumbai, Maharashtra', 1500.00, 'REG001', 8.5, 'RENTED'),
('123e4567-e89b-12d3-a456-426614174113', 'RESIDENTIAL', 'Bangalore, Karnataka', 1800.00, 'REG002', 4.5, 'RENTED');

-- Insert NPS details
INSERT INTO nps (id, pran_number, scheme_preference, equity_allocation, debt_allocation, govt_securities_allocation, tier_type) VALUES
('123e4567-e89b-12d3-a456-426614174114', 'PRAN001', 'AUTO_CHOICE', 75.00, 15.00, 10.00, 'TIER_1'),
('123e4567-e89b-12d3-a456-426614174115', 'PRAN002', 'ACTIVE_CHOICE', 50.00, 30.00, 20.00, 'TIER_2');
