CREATE TABLE `vaccinations`(
  `vaccination_id` BIGINT NOT NULL AUTO_INCREMENT,
  `citizen_id` BIGINT NOT NULL,
  `vaccination_date` DATETIME NOT NULL,
  `status` VARCHAR(10),
  `note` VARCHAR(250),
  `vaccination_type` VARCHAR(20),
  PRIMARY KEY(`vaccination_id`),
  CONSTRAINT fk_vaccinatins_citizens
    FOREIGN KEY(citizen_id) REFERENCES citizens(citizen_id)
);