CREATE TABLE `activities`(
  `activity_id` BIGINT AUTO_INCREMENT,
  `activity_starttime` TIMESTAMP,
  `activity_desc` VARCHAR(255) ,
  `activity_type` ENUM('BIKING','HIKING','RUNNING', 'BASKETBALL'),
  PRIMARY KEY (`activity_id`));