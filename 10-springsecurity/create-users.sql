USE `employee_tracker`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `username` varchar(50) NOT NULL,
	`password` char(68) NOT NULL,
	`enabled` tinyint NOT NULL,
    
	PRIMARY KEY(`username`)
);

INSERT INTO `users` VALUES 
	('john','{bcrypt}$2a$12$5PU9kPFZg4tBXUeMCskkgOZExN7Sko4NC3bMPIkQJ3druwLgcQohu',1),
    ('mary','{bcrypt}$2a$12$cP1yf9RYvirBCku0jqaI2.jy4JBy6da4BBP2tVi8lfkHWP5.h3aPi',1),
    ('susan','{bcrypt}$2a$12$gACTANgUv/tJ/c2GtMh23OJFGQrL0pamCVXnFJXYH3h6Yog/xDCO2',1);
