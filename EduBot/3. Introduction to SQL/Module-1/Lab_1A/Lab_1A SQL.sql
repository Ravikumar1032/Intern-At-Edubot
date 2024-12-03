-- Database: Lab_1A

-- DROP DATABASE IF EXISTS "Lab_1A";

CREATE DATABASE "Lab_1A"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Hindi_India.utf8'
    LC_CTYPE = 'Hindi_India.utf8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    enrollment_date DATE
);

INSERT INTO students (name, age, enrollment_date) VALUES
('sajida', 21, '2023-09-01'),
('ameena', 22, '2023-09-02'),
('mehtaj', 20, '2023-09-03'),
('udaya', 23, CURRENT_DATE);


SELECT *FROM students;

SELECT name, age FROM students;

SELECT *FROM students WHERE age > 21;

SELECT *FROM students ORDER BY name;

SELECT COUNT(*) FROM students;
