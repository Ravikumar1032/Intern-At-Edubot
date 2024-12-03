-- Drop the table if it exists
DROP TABLE IF EXISTS meat_poultry_egg_inspect;

-- Create the table
CREATE TABLE meat_poultry_egg_inspect (
    est_number varchar(50) CONSTRAINT est_number_key PRIMARY KEY,
    company varchar(100),
    street varchar(100),
    city varchar(30),
    st varchar(2),
    zip varchar(5),
    phone varchar(14),
    grant_date date,
    activities text,
    dbas text
);

-- Populate the table with data from the CSV file
COPY meat_poultry_egg_inspect
FROM 'C:/Program Files/PostgreSQL/16/MPI_Directory_by_Establishment_Name.csv'
WITH (FORMAT CSV, HEADER, DELIMITER ',');

-- Create an index on the company column
CREATE INDEX company_idx ON meat_poultry_egg_inspect (company);

-- Find rows with missing state (st) values
SELECT est_number, company, city, st, zip
FROM meat_poultry_egg_inspect
WHERE st IS NULL;

-- Count rows with missing state (st) values
SELECT count(*)
FROM meat_poultry_egg_inspect
WHERE st IS NULL;

-- Find and count inconsistent company names
SELECT company, count(*) AS company_count
FROM meat_poultry_egg_inspect
GROUP BY company
ORDER BY company_count DESC;

-- Find and count companies with multiple establishments at the same address
SELECT company, street, city, st, count(*) AS address_count
FROM meat_poultry_egg_inspect
GROUP BY company, street, city, st
HAVING count(*) > 1
ORDER BY address_count DESC;
