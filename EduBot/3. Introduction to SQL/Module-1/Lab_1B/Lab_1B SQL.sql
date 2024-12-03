CREATE TABLE sales_person1 (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE product_type1 (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE product1 (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    product_type_id INT REFERENCES product_type1(id),
    price NUMERIC(15, 2)
);

CREATE TABLE item1 (
    id SERIAL PRIMARY KEY,
    product_id INT REFERENCES product1(id),
    serial_number VARCHAR(50)
);

CREATE TABLE sales_order1 (
    id SERIAL PRIMARY KEY,
    order_date DATE,
    sales_person_id INT REFERENCES sales_person1(id),
    customer_id INT,
    order_number BIGINT
);

CREATE TABLE sales_item1 (
    id SERIAL PRIMARY KEY,
    sales_order_id INT REFERENCES sales_order1(id),
    item_id INT REFERENCES item1(id),
    quantity INT
);

CREATE INDEX idx_sales_person1_email ON sales_person1(email);

DELETE FROM sales_person1 WHERE id = 1;

DROP TABLE sales_item1;

INSERT INTO product_type1 (name) VALUES
('Electronics'), 
('Furniture'), 
('Clothing');

INSERT INTO product1 (name, product_type_id, price) VALUES
('Laptop', 1, 999.99),
('Desk', 2, 199.99),
('T-Shirt', 3, 19.99);

SELECT * FROM product_type1;
SELECT * FROM product1;

CREATE TABLE customer1 (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    zip VARCHAR(10)
);

ALTER TABLE customer1
ALTER COLUMN zip TYPE INTEGER USING zip::INTEGER;

INSERT INTO customer1 (first_name, last_name, email, zip) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com', 12345),
('Bob', 'Lee', 'bob.lee@example.com', 67890),
('Charlie', 'Kim', 'charlie.kim@example.com', 54321);

INSERT INTO sales_person1 (first_name, last_name, email) VALUES
('John', 'Doe', 'john.doe@example.com'),
('Jane', 'Smith', 'jane.smith@example.com'),
('Jim', 'Brown', 'jim.brown@example.com');

INSERT INTO sales_order1 (order_date, sales_person_id, customer_id, order_number) VALUES
('2023-01-01', 1, 1, 1000001),
('2023-02-01', 2, 2, 1000002),
('2023-03-01', 3, 3, 1000003);

INSERT INTO item1 (product_id, serial_number) VALUES
(1, 'SN123456'), 
(2, 'SN654321'), 
(3, 'SN987654');

CREATE TABLE sales_item1 (
    id SERIAL PRIMARY KEY,
    sales_order_id INT REFERENCES sales_order1(id),
    item_id INT REFERENCES item1(id),
    quantity INT
);

INSERT INTO sales_item1 (sales_order_id, item_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 5);

SELECT * FROM customer1;
SELECT * FROM sales_order1;
SELECT * FROM item1;
SELECT * FROM sales_item1;
SELECT * FROM sales_person1;
