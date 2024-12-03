CREATE TABLE passwords (
    id SERIAL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    creation_date DATE NOT NULL,
    strength INT NOT NULL,
    used BOOLEAN NOT NULL
);

SELECT * FROM passwords;
