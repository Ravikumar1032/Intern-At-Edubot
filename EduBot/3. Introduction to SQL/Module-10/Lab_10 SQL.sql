-- Create a test database
CREATE DATABASE testdb;
\c testdb;

-- Create tables
CREATE TABLE accounts (
    account_id SERIAL PRIMARY KEY,
    balance NUMERIC
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT
);

-- Insert some data into accounts table
INSERT INTO accounts (balance) VALUES (1000);

-- Test the first transaction
BEGIN TRANSACTION;

UPDATE accounts SET balance = balance - 100 WHERE account_id = 1;

INSERT INTO orders (order_id, customer_id, product_id, quantity)
VALUES (1, 1, 1, 1);

COMMIT;

-- Test the second transaction
-- Test the second transaction
DO $$
BEGIN
    BEGIN
        INSERT INTO orders (order_id, customer_id, product_id, quantity)
        VALUES (1, 1, 1, 1);
        
        IF 1 = 2 THEN 
           COMMIT;
        ELSE
           ROLLBACK;
        END IF;
    EXCEPTION
        WHEN others THEN
            ROLLBACK;
    END;
END $$;

-- Test the second transaction
DO $$
DECLARE
    success BOOLEAN := false;
BEGIN
    BEGIN
        INSERT INTO orders (order_id, customer_id, product_id, quantity)
        VALUES (1, 1, 1, 1);
        
        IF 1 = 2 THEN 
           COMMIT;
           success := true;
        ELSE
           ROLLBACK;
           success := false;
        END IF;
    EXCEPTION
        WHEN others THEN
            ROLLBACK;
            success := false;
    END;
    
    -- Output success status
    RAISE NOTICE 'Transaction completed successfully: %', success;
END $$;

select *from accounts ;
