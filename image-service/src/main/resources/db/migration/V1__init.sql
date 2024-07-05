CREATE TABLE `image`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT,
    `title`          varchar(40),
    `description`    varchar(255),
    `country`        varchar(20),
    `city`           varchar(20),
    `lat`            decimal(7, 4),
    `lng`            decimal(7, 4),
    `file_name`       varchar(100),
     PRIMARY KEY (`id`)
)
