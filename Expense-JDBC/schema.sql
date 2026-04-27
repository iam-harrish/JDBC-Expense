CREATE DATABASE expense_tracker;
USE expense_tracker;
CREATE TABLE expenses (id INT AUTO_INCREMENT PRIMARY KEY,date DATE,category VARCHAR(50),amount DOUBLE);
INSERT INTO expenses (date, category, amount)
VALUES ('2026-04-27', 'Food', 200);
SELECT * FROM expenses;
