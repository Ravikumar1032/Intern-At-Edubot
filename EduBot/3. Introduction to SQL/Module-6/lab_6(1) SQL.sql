-- Create the table
CREATE TABLE check_constraint_example1 (
    user_id bigserial,
    user_role varchar(50),
    salary integer,
    CONSTRAINT user_id_key1 PRIMARY KEY (user_id),
    CONSTRAINT check_role_in_list1 CHECK (user_role IN ('Admin', 'Staff')),
    CONSTRAINT check_salary_nonzero1 CHECK (salary > 0)
);

-- Test insertion violating the CHECK constraint for user_role
INSERT INTO check_constraint_example1 (user_role, salary) VALUES ('Guest', 1000);
-- This should fail because 'Guest' is not in the allowed list ('Admin', 'Staff')

-- Test insertion violating the CHECK constraint for salary
INSERT INTO check_constraint_example1 (user_role, salary) VALUES ('Admin', 0);
-- This should fail because salary must be greater than 0
