USE `manage_edu_db`;
DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`id` int NOT NULL AUTO_INCREMENT,
    `comment` varchar(256) DEFAULT NULL,
    `course_id` int DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) AUTO_INCREMENT = 1 ;