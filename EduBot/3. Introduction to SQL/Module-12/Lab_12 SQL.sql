CREATE TYPE party_enum AS ENUM ('U', 'R', 'D');

CREATE TYPE status_enum AS ENUM ('Enabled', 'Disabled');


CREATE TABLE Voters (
    VoterID SERIAL PRIMARY KEY,
    FirstName VARCHAR(30),
    LastName VARCHAR(30),
    Address VARCHAR(255),
    Party party_enum,
    PresidentialPrimaryParty16Party party_enum,
    PrimaryParty16Party party_enum,
    PrimaryParty14Party party_enum,
    PresidentialPrimaryParty12Party party_enum,
    PrimaryParty12Party party_enum
);

COPY Voters(FirstName, LastName, Address, Party, PresidentialPrimaryParty16Party, PrimaryParty16Party, PrimaryParty14Party, PresidentialPrimaryParty12Party, PrimaryParty12Party)
FROM 'C:\Program Files\PostgreSQL\16\sql_files\Lab_12\voter_list_CRN207.csv'
DELIMITER ','
CSV HEADER;

--Create the Regions and StateStatus Tables
CREATE TABLE Regions (
    State VARCHAR(50) PRIMARY KEY,
    Region VARCHAR(20)
);


INSERT INTO Regions (State, Region) VALUES
('Connecticut', 'Northeast'),
('Delaware', 'Northeast'),
('Maine', 'Northeast'),
('Maryland', 'Northeast'),
('Massachusetts', 'Northeast'),
('New Hampshire', 'Northeast'),
('New Jersey', 'Northeast'),
('New York', 'Northeast'),
('Pennsylvania', 'Northeast'),
('Rhode Island', 'Northeast'),
('Vermont', 'Northeast'),
('Illinois', 'Midwest'),
('Indiana', 'Midwest'),
('Iowa', 'Midwest'),
('Kansas', 'Midwest'),
('Michigan', 'Midwest'),
('Minnesota', 'Midwest'),
('Missouri', 'Midwest'),
('Nebraska', 'Midwest'),
('North Dakota', 'Midwest'),
('Ohio', 'Midwest'),
('South Dakota', 'Midwest'),
('Wisconsin', 'Midwest'),
('Alabama', 'South'),
('Arkansas', 'South'),
('Florida', 'South'),
('Georgia', 'South'),
('Kentucky', 'South'),
('Louisiana', 'South'),
('Mississippi', 'South'),
('North Carolina', 'South'),
('South Carolina', 'South'),
('Tennessee', 'South'),
('Texas', 'South'),
('Virginia', 'South'),
('West Virginia', 'South'),
('Alaska', 'West'),
('Arizona', 'West'),
('California', 'West'),
('Colorado', 'West'),
('Hawaii', 'West'),
('Idaho', 'West'),
('Montana', 'West'),
('Nevada', 'West'),
('New Mexico', 'West'),
('Oregon', 'West'),
('Utah', 'West'),
('Washington', 'West'),
('Wyoming', 'West');



CREATE TABLE StateStatus (
    State VARCHAR(50) PRIMARY KEY,
    Status status_enum
);

INSERT INTO StateStatus (State, Status) VALUES
('Alabama', 'Enabled'),
('Alaska', 'Enabled'),
('Arizona', 'Enabled'),
('Arkansas', 'Enabled'),
('California', 'Enabled'),
('Colorado', 'Enabled'),
('Connecticut', 'Enabled'),
('Delaware', 'Enabled'),
('District of Columbia', 'Enabled'),
('Florida', 'Enabled'),
('Georgia', 'Enabled'),
('Hawaii', 'Enabled'),
('Idaho', 'Enabled'),
('Illinois', 'Enabled'),
('Indiana', 'Enabled'),
('Iowa', 'Enabled'),
('Kansas', 'Enabled'),
('Kentucky', 'Enabled'),
('Louisiana', 'Enabled'),
('Maine', 'Enabled'),
('Maryland', 'Enabled'),
('Massachusetts', 'Enabled'),
('Michigan', 'Enabled'),
('Minnesota', 'Enabled'),
('Mississippi', 'Enabled'),
('Missouri', 'Enabled'),
('Montana', 'Enabled'),
('Nebraska', 'Enabled'),
('Nevada', 'Enabled'),
('New Hampshire', 'Enabled'),
('New Jersey', 'Enabled'),
('New Mexico', 'Enabled'),
('New York', 'Enabled'),
('North Carolina', 'Enabled'),
('North Dakota', 'Enabled'),
('Ohio', 'Enabled'),
('Oklahoma', 'Enabled'),
('Oregon', 'Enabled'),
('Pennsylvania', 'Enabled'),
('Rhode Island', 'Enabled'),
('South Carolina', 'Enabled'),
('South Dakota', 'Enabled'),
('Tennessee', 'Enabled'),
('Texas', 'Enabled'),
('Utah', 'Enabled'),
('Vermont', 'Enabled'),
('Virginia', 'Enabled'),
('Washington', 'Enabled'),
('West Virginia', 'Enabled'),
('Wisconsin', 'Enabled'),
('Wyoming', 'Enabled');


-- Total number of voters
SELECT COUNT(*) AS TotalVoters FROM Voters;

-- Number of voters by party
SELECT Party, COUNT(*) AS VoterCount
FROM Voters
GROUP BY Party;
--How many voters share the same first and last names? What are these names?

SELECT r.Region, v.Party, COUNT(*) AS VoterCount
FROM Voters v
JOIN Regions r ON SUBSTRING(v.Address FROM '.*, ([A-Z]{2}) .*') = r.State
GROUP BY r.Region, v.Party
ORDER BY VoterCount DESC;
--How many voters have a last name that starts with the letter “Z”
SELECT FirstName, LastName, COUNT(*) AS NameCount
FROM Voters
GROUP BY FirstName, LastName
HAVING COUNT(*) > 1;
--Show the voters with the last names that start with Z by region.
SELECT v.FirstName, v.LastName, r.Region
FROM Voters v
JOIN Regions r ON SUBSTRING(v.Address FROM '.*, ([A-Z]{2}) .*') = r.State
WHERE v.LastName LIKE 'Z%';

-- Identify the voters who voted the same way in every primary election

SELECT FirstName, LastName, Address
FROM Voters
WHERE Party = PresidentialPrimaryParty16Party
AND Party = PrimaryParty16Party
AND Party = PrimaryParty14Party
AND Party = PresidentialPrimaryParty12Party
AND Party = PrimaryParty12Party;

-- Does Medicaid expansion show a relationship with voting change?

-- Add a column to indicate if a voter has changed their voting pattern
ALTER TABLE Voters
ADD COLUMN VotingChange BOOLEAN;

-- Update the column based on voting pattern
UPDATE Voters
SET VotingChange = CASE
    WHEN Party != PresidentialPrimaryParty16Party
    OR Party != PrimaryParty16Party
    OR Party != PrimaryParty14Party
    OR Party != PresidentialPrimaryParty12Party
    OR Party != PrimaryParty12Party THEN TRUE
    ELSE FALSE
END;
--Query Relationship with Medicaid Expansion
SELECT ss.Status, COUNT(v.VoterID) AS VoterCount, SUM(CASE WHEN v.VotingChange THEN 1 ELSE 0 END) AS ChangeCount
FROM Voters v
JOIN Regions r ON SUBSTRING(v.Address FROM '.*, ([A-Z]{2}) .*') = r.State
JOIN StateStatus ss ON r.State = ss.State
GROUP BY ss.Status;

--Compare voting behavior (change/stay the same) by region
SELECT r.Region, COUNT(v.VoterID) AS VoterCount, SUM(CASE WHEN v.VotingChange THEN 1 ELSE 0 END) AS ChangeCount
FROM Voters v
JOIN Regions r ON SUBSTRING(v.Address FROM '.*, ([A-Z]{2}) .*') = r.State
GROUP BY r.Region;

-- Create a temporary table to store extracted state
CREATE TEMP TABLE TempVoters AS
SELECT *,
       SUBSTRING(Address FROM '.*, ([A-Z]{2}) \d{5}$') AS State
FROM Voters;

-- Create a temporary table to store extracted zip code
CREATE TEMP TABLE TempVotersZip AS
SELECT *,
       SUBSTRING(Address FROM '(\d{5})$') AS ZipCode
FROM Voters;


--Is there a relationship between region and Medicaid expansion?
SELECT r.Region, ss.Status, COUNT(tv.VoterID) AS VoterCount
FROM TempVoters tv
JOIN Regions r ON tv.State = r.State
JOIN StateStatus ss ON tv.State = ss.State
GROUP BY r.Region, ss.Status;

--Produce a query showing voting behavior by zip code
SELECT ZipCode, COUNT(VoterID) AS VoterCount, SUM(CASE WHEN VotingChange THEN 1 ELSE 0 END) AS ChangeCount
FROM TempVotersZip
GROUP BY ZipCode;





