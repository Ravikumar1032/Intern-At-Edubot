CREATE TABLE check_constraint_logical (
    id bigserial PRIMARY KEY,
    value1 integer,
    value2 integer,
    CONSTRAINT check_values_logical CHECK (value1 > 0 AND value2 > 0)
);

-- Test insertion violating the CHECK constraint
INSERT INTO check_constraint_logical (value1, value2) VALUES (-1, 10);
-- This should fail because value1 is not greater than 0

INSERT INTO check_constraint_logical (value1, value2) VALUES (5, -5);
-- This should fail because value2 is not greater than 0
