CREATE DATABASE task_planner;
USE task_planner;
CREATE TABLE tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    description TEXT,
    category VARCHAR(100),
    deadline DATE
);
INSERT INTO tasks (task_name, description, category, deadline)
VALUES
('Clean the house', 'Kitchen and bedroom', 'Home', '2025-01-24');

