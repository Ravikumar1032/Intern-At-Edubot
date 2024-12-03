CREATE TABLE natural_key_example (
    license_id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);
INSERT INTO natural_key_example (license_id, first_name, last_name)
VALUES ('PA46522', 'Bill', 'Maloney'),
       ('PA46523', 'Jane', 'Jefferson');
CREATE TABLE surrogate_key_example (
    order_number BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(50),
    order_date DATE
);
INSERT INTO surrogate_key_example (product_name, order_date)
VALUES ('Shoe Scuffer', '2022-12-03'),
       ('Tire Unbalancer', '2023-01-03'),
       ('Stain Enhancer', '2021-08-07');

SELECT * FROM natural_key_example;


SELECT * FROM surrogate_key_example;

SELECT * FROM surrogate_key_example
WHERE order_date BETWEEN '2022-01-01' AND '2022-12-31';
