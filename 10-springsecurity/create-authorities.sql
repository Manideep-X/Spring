USE `employee_tracker`;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
	`username` varchar(50) NOT NULL,
	`authority` varchar(50) NOT NULL,
    
    UNIQUE KEY (`username`,`authority`),
    FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);

-- "ROLE_" prefix is used by Spring Security
INSERT INTO `authorities` VALUES
	('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN');
