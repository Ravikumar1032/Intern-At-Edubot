-- Create table
CREATE TABLE discounts (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    expired_date DATE,
    amount INTEGER
);

-- Import CSV data into the table
COPY discounts FROM 'C:\Program Files\PostgreSQL\16\discounts.csv' DELIMITER ',' CSV HEADER;

-- Calculate the sum of the amounts column
SELECT SUM(amount) AS total_amount FROM discounts;


