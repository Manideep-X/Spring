USE `manage_edu_db`;
DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
	`id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(128) DEFAULT NULL,
    `instructor_id` int DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    UNIQUE KEY (`title`),
    FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`)
) AUTO_INCREMENT = 10 ;