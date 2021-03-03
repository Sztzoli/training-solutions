CREATE TABLE `citizens` (
  `citizen_id` BIGINT NOT NULL AUTO_INCREMENT,
  `citizen_name` VARCHAR(200) NOT NULL,
  `zip` VARCHAR(4)  NOT NULL,
  `age` BIGINT NOT NULL,
  `email` VARCHAR(200),
  `taj` VARCHAR(10),
  `number_of_vaccination` BIGINT DEFAULT 0,
  `last_vaccination` DATETIME,
  PRIMARY KEY(`citizen_id`)
);