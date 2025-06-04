USE `employee_tracker`;

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
	`user_name` varchar(50) NOT NULL,
	`user_role` varchar(50) NOT NULL,
    
    UNIQUE KEY (`user_name`,`user_role`),
    FOREIGN KEY (`user_name`) REFERENCES `members` (`name`)
);

-- "ROLE_" prefix is used by Spring Security
INSERT INTO `roles` VALUES
	('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN');
