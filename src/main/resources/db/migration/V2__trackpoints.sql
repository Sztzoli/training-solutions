CREATE TABLE `track_points`(
  `activity_id` BIGINT,
  `id` BIGINT AUTO_INCREMENT,
  `track_time` DATE,
  `lat` BIGINT,
  `lon` BIGINT,
  PRIMARY KEY (`id`),
   CONSTRAINT `fk_track_activity`
  FOREIGN KEY (`activity_id`) REFERENCES activities (`activity_id`));