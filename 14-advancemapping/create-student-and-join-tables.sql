USE `manage_edu_db`;

DROP TABLE IF EXISTS `student_course`;
DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 1 ;

CREATE TABLE `student_course` (
	`student_id` int NOT NULL,
    `course_id` int NOT NULL,
    
    PRIMARY KEY (`student_id`, `course_id`),
    FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
    FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
);