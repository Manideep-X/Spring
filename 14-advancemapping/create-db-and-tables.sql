CREATE DATABASE IF NOT EXISTS `manage_edu_db`;
USE `manage_edu_db`;

-- SET FOREIGN_KEY_CHECKS = 0; 

DROP TABLE IF EXISTS `instructor`;
DROP TABLE IF EXISTS `instructor_detail`;
# Can't delete parent table(instructor_detail) first as the child table(instructor) still using it.

-- SET FOREIGN_KEY_CHECKS = 1;

# Below is the Parent table
CREATE TABLE `instructor_detail` (

	`id` int NOT NULL AUTO_INCREMENT,
    `portfolio` varchar(128) DEFAULT NULL,
    `hobby` varchar(45) DEFAULT NULL,
    
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 1;

# Below is the Child table as it contains the foreign key
CREATE TABLE `instructor` (

	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    `instructor_detail_id` int DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`)
    -- ON DELETE NO ACTION ON UPDATE NO ACTION
    # Above is not needed as by default MySQL uses "on delete restrict on update restrict" which is identical to the above.
) AUTO_INCREMENT = 1;