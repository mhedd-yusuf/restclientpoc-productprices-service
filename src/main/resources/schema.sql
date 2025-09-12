CREATE TABLE IF NOT EXISTS price (
    id BIGINT PRIMARY KEY,
    amount DECIMAL(12,2) NOT NULL,
    currency VARCHAR(8) NOT NULL,
    price_type VARCHAR(16) NOT NULL
    );
