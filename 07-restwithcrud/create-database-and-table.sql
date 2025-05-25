CREATE DATABASE IF NOT EXISTS `employee_tracker`;
USE `employee_tracker`;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;