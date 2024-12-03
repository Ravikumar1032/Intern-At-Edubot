-- Step 1: Create the table
CREATE TABLE us_counties_2010 (
    geo_name varchar(90),
    state_us_abbreviation varchar(2),
    summary_level varchar(3),
    region smallint,
    division smallint,
    state_fips varchar(2),
    county_fips varchar(3),
    area_land bigint,
    area_water bigint,
    population_count_100_percent integer,
    housing_unit_count_100_percent integer,
    internal_point_lat numeric(10,7),
    internal_point_lon numeric(10,7),
    p0010001 integer,   
    p0010002 integer,   
    p0010003 integer,       
    p0010004 integer,       
    -- (continue all columns...)
    h0010002 integer,   
    h0010003 integer    
);

SELECT * FROM us_counties_2010;

-- Step 2: Copy data from the CSV file into the table
COPY us_counties_2010
FROM 'C:\Users\asus\Downloads\us_counties_2010.csv'
WITH (FORMAT CSV, HEADER);


-- Step 4: Query to show counties with the largest land area
SELECT geo_name, state_us_abbreviation, area_land
FROM us_counties_2010
ORDER BY area_land DESC
LIMIT 3;


