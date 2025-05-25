DROP USER if exists 'learningspring'@'localhost' ;
CREATE USER 'learningspring'@'localhost' IDENTIFIED BY 'learningspring';
GRANT ALL PRIVILEGES ON * . * TO 'learningspring'@'localhost';

-- #1 Line: Delete existing user if any of name springstudent from MySQL server for connecting from localhost(127.0.0.1).
-- #2 Line: Create a new user that can connect from localhost and set the password as springstudent.
-- #3 Line: Grant all permission to all databases and tables to this newly created user.