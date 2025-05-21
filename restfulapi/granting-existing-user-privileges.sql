-- These queries should be executed by a root user.
DROP USER IF EXISTS 'learningspring'@'localhost';
CREATE USER 'learningspring'@'localhost' IDENTIFIED BY 'learningspring';
GRANT ALL PRIVILEGES ON *.* TO 'learningspring'@'localhost' WITH GRANT OPTION;