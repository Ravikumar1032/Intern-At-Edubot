CREATE TABLE Customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    address VARCHAR(255),
    phone_number VARCHAR(20),
    birthdate DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Orders (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES Customers(id),
    order_date DATE,
    order_total NUMERIC(10,2),
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Bears (
    BearID SERIAL PRIMARY KEY,
    Name VARCHAR(100),
    Type VARCHAR(100),
    Size VARCHAR(20),
    Color VARCHAR(20),
    Price NUMERIC(10,2)
);

CREATE TABLE Parts (
    PartID SERIAL PRIMARY KEY,
    Name VARCHAR(100),
    Type VARCHAR(100),
    Color VARCHAR(20),
    Cost NUMERIC(10,2)
);

CREATE TABLE Transactions (
    TransactionID SERIAL PRIMARY KEY,
    BearID INT REFERENCES Bears(BearID),
    Price NUMERIC(10,2),
    PaymentMethod VARCHAR(50),
    TransactionDate DATE,
    TransactionStatus VARCHAR(20)
);

CREATE TABLE Returns (
    ReturnID SERIAL PRIMARY KEY,
    TransactionID INT REFERENCES Transactions(TransactionID),
    ReturnDate DATE,
    Reason VARCHAR(255)
);

CREATE TABLE BearParts (
    BearID INT REFERENCES Bears(BearID),
    PartID INT REFERENCES Parts(PartID),
    PRIMARY KEY (BearID, PartID)
);
