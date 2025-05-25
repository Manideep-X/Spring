-- created a DB of name "student_tracker". Inside it, created a table named as "student"
-- the table student have:
-- 			1. id(Not null, primary) which increment automatically
-- 			2. first_name
-- 			3. last_name 
-- 			4. email 

create database if not exists `student_tracker`;
use `student_tracker`;

drop table if exists `student`;
create table `student` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45), -- MySQL will automatically assume DEFAULT NULL unless NOT NULL is mentioned.
    `email` VARCHAR(45),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
-- InnoDB is a storage engines to manage how data is stored, retrieved, and modified on disk.
-- Key features of InnoDB: Transactions, foreign keys, row-level locking, crash recovery.
-- DEFAULT CHARSET=utf8mb4 -- This means all text columns in this table (like name) will use the utf8mb4 character set.
						   -- It determine how the text data(like VARCHAR) are encoded (it means how those characters are mapped to bytes) and stored.