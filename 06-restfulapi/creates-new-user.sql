DROP USER IF EXISTS 'studentadmin'@'localhost';
CREATE USER 'studentadmin'@'localhost' IDENTIFIED BY 'studentadmin';
GRANT ALL PRIVILEGES ON *.* TO 'studentadmin'@'localhost';
