CREATE TABLE constraints_example (
    id bigserial PRIMARY KEY,
    username varchar(50) NOT NULL,
    email varchar(100) UNIQUE
);

-- Test NOT NULL constraint
INSERT INTO constraints_example (username) VALUES (NULL);
-- This should fail because username cannot be NULL

-- Test UNIQUE constraint
INSERT INTO constraints_example (username, email) VALUES ('user1', 'user1@example.com');
INSERT INTO constraints_example (username, email) VALUES ('user2', 'user1@example.com');
-- This should fail because email must be unique
--Alter the constraints
ALTER TABLE constraints_example DROP CONSTRAINT constraints_example_email_key;

ALTER TABLE constraints_example ADD CONSTRAINT check_username_length CHECK (char_length(username) >= 3);

ALTER TABLE constraints_example  ADD CONSTRAINT constraints_example_email_key CHECK (char_length(username) >= 3);

ALTER TABLE check_constraint_example DROP CONSTRAINT check_salary_nonzero;

ALTER TABLE check_constraint_example ADD CONSTRAINT check_salary_min CHECK (salary > 1000);

SELECT * FROM constraints_example;

EXPLAIN SELECT * FROM check_constraint_example;
EXPLAIN SELECT user_id, user_role, salary FROM check_constraint_example;


-- Create the primary table
CREATE TABLE primary_table (
    id bigserial PRIMARY KEY,
    name varchar(50)
);

-- Create the related table with a foreign key
CREATE TABLE related_table (
    id bigserial PRIMARY KEY,
    primary_id bigint,
    detail varchar(50),
    CONSTRAINT fk_primary FOREIGN KEY (primary_id) REFERENCES primary_table(id) ON DELETE CASCADE
);

-- Insert data into primary_table
INSERT INTO primary_table (name) VALUES ('Primary1');
-- Insert data into related_table referencing primary_table
INSERT INTO related_table (primary_id, detail) VALUES (1, 'Detail1');

-- Delete from primary_table and observe cascading delete in related_table
DELETE FROM primary_table WHERE id = 1;
-- This should also delete the related row in related_table
