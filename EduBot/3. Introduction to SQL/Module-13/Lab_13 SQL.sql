-- Create ENUM types
CREATE TYPE party_enum3 AS ENUM ('U', 'R', 'D');
CREATE TYPE status_enum2 AS ENUM ('Enabled', 'Disabled');

-- Create Voters Table
CREATE TABLE Voters1 (
    VoterID SERIAL PRIMARY KEY,
    FirstName VARCHAR(30),
    LastName VARCHAR(30),
    Address VARCHAR(255),
    Party party_enum3,
    PresidentialPrimaryParty16Party party_enum3,
    PrimaryParty16Party party_enum3,
    PrimaryParty14Party party_enum3,
    PresidentialPrimaryParty12Party party_enum3,
    PrimaryParty12Party party_enum3
);

-- Copy data into Voters Table
COPY Voters(FirstName, LastName, Address, Party, PresidentialPrimaryParty16Party, PrimaryParty16Party, PrimaryParty14Party, PresidentialPrimaryParty12Party, PrimaryParty12Party)
FROM 'C:\\Program Files\\PostgreSQL\\16\\sql_files\\Lab_12\\voter_list_CRN207.csv'
DELIMITER ','
CSV HEADER;

-- Create Regions Table
CREATE TABLE Regions1 (
    State VARCHAR(50) PRIMARY KEY,
    Region VARCHAR(20)
);

-- Insert regions data
INSERT INTO Regions1 (State, Region) VALUES
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

-- Create StateStatus Table
CREATE TABLE StateStatus1 (
    State VARCHAR(50) PRIMARY KEY,
    Status status_enum
);

-- Insert state status data
INSERT INTO StateStatus1 (State, Status) VALUES
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

-- Create ArchivedVoters Table
CREATE TABLE ArchivedVoters1 (
    VoterID SERIAL PRIMARY KEY,
    FirstName VARCHAR(30),
    LastName VARCHAR(30),
    Address VARCHAR(255),
    Party party_enum3,
    PresidentialPrimaryParty16Party party_enum3,
    PrimaryParty16Party party_enum3,
    PrimaryParty14Party party_enum3,
    PresidentialPrimaryParty12Party party_enum3,
    PrimaryParty12Party party_enum3,
    DeletedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the trigger function
CREATE OR REPLACE FUNCTION archive_voter() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO ArchivedVoters1 (
        FirstName, LastName, Address, Party,
        PresidentialPrimaryParty16Party, PrimaryParty16Party,
        PrimaryParty14Party, PresidentialPrimaryParty12Party,
        PrimaryParty12Party
    )
    VALUES (
        OLD.FirstName, OLD.LastName, OLD.Address, OLD.Party,
        OLD.PresidentialPrimaryParty16Party, OLD.PrimaryParty16Party,
        OLD.PrimaryParty14Party, OLD.PresidentialPrimaryParty12Party,
        OLD.PrimaryParty12Party
    );
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger
CREATE TRIGGER before_voter_delete
BEFORE DELETE ON Voters
FOR EACH ROW
EXECUTE FUNCTION archive_voter();
