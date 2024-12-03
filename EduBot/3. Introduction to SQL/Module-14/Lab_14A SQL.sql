-- Connect to the build-a-bear database

-- Step 1: Create the items table (if it doesn't exist)
DROP TABLE IF EXISTS items;

CREATE TABLE items (
    item_id SERIAL PRIMARY KEY,
    item_name VARCHAR(100) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL
);

-- Step 2: Populate the items table
INSERT INTO items (item_name, cost) VALUES
('Ravikumar', 20.00),
('Sajida', 15.00),
('Jashmin', 25.00),
('Sravani', 13.00),
('Jyothi Sai', 30.00);

-- Step 3: Create the stored procedure to increase item costs by 10%
CREATE OR REPLACE PROCEDURE increase_costs_by_10()
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE items
    SET cost = cost * 1.10;
END;
$$;

-- Step 4: Call the stored procedure
CALL increase_costs_by_10();

-- Step 5: Verify the data in the items table
SELECT * FROM items;
