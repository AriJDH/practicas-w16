CREATE DATABASE qa_tester_db;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'admin'@'localhost';
