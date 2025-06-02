USE `employee_tracker`;

DROP TABLE IF EXISTS `employee_tracker`;
CREATE TABLE `users` (
    `username` varchar(50) NOT NULL,
	`password` varchar(50) NOT NULL,
	`enabled` tinyint NOT NULL,
    
	PRIMARY KEY(`username`)
);

INSERT INTO `users` VALUES 
	('john','{noop}123',1),
    ('mary','{noop}123',1),
    ('susan','{noop}123',1);
