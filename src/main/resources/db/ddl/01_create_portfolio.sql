-- Create Portfolio table
CREATE TABLE portfolios (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    total_value DECIMAL(20,2),
    asset_count INTEGER,
    status VARCHAR(50),
    version BIGINT DEFAULT 0
);
