
/*
Create the Database and Tables with Constraints
Connect to PostgreSQL and Create the Database:
*/

CREATE DATABASE todo_list;
\c todo_list

--Create the Tables without Constraints:
-- Create Project table
CREATE TABLE project (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    project_description TEXT
);

-- Create User table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Task_Type table
CREATE TABLE task_type (
    type_id SERIAL PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL,
    type_description TEXT
);

-- Create Status_Type table
CREATE TABLE status_type (
    status_id SERIAL PRIMARY KEY,
    status_name VARCHAR(255) NOT NULL,
    status_description TEXT
);

-- Create Task table
CREATE TABLE task (
    task_id SERIAL PRIMARY KEY,
    list_id INTEGER,  -- Assuming a list_id that is part of a task
    project_id INTEGER,
    user_id INTEGER,
    task_title VARCHAR(255) NOT NULL,
    task_description TEXT,
    task_due_date DATE,
    task_status INTEGER,
    task_priority VARCHAR(6) CHECK (task_priority IN ('High', 'Medium', 'Low')),
    task_recurring BOOLEAN,
    comment TEXT
);


--Populate the Database with Sample Data:
-- Insert into Project
INSERT INTO project (project_name, project_description) VALUES 
('Project A', 'Description for Project A'),
('Project B', 'Description for Project B');

-- Insert into User
INSERT INTO users (name, email, password) VALUES 
('Alice', 'alice@example.com', 'password123'),
('Bob', 'bob@example.com', 'password456');

-- Insert into Task_Type
INSERT INTO task_type (type_name, type_description) VALUES 
('Bug', 'A bug task type'),
('Feature', 'A feature task type');

-- Insert into Status_Type
INSERT INTO status_type (status_name, status_description) VALUES 
('Open', 'Task is open'),
('In Progress', 'Task is in progress'),
('Closed', 'Task is closed');

-- Insert into Task
INSERT INTO task (list_id, project_id, user_id, task_title, task_description, task_due_date, task_status, task_priority, task_recurring, comment) VALUES 
(1, 1, 1, 'Task 1', 'Description for Task 1', '2024-06-01', 1, 'High', TRUE, 'No comments'),
(2, 2, 2, 'Task 2', 'Description for Task 2', '2024-06-15', 2, 'Medium', FALSE, 'No comments');

--Add Constraints
-- Add Foreign Key constraints
ALTER TABLE task
ADD CONSTRAINT fk_project
FOREIGN KEY (project_id) 
REFERENCES project (project_id);

ALTER TABLE task
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) 
REFERENCES users (user_id);

ALTER TABLE task
ADD CONSTRAINT fk_task_status
FOREIGN KEY (task_status) 
REFERENCES status_type (status_id);

SELECT * FROM task;
SELECT * FROM project;
SELECT * FROM users;
