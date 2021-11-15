CREATE DATABASE IF NOT EXISTS springmvcdb;

USE spring_mvc;

DROP TABLE IF EXISTS `springmvcdb`.`users`;

CREATE TABLE `springmvcdb`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` INT NULL,
  PRIMARY KEY (`username`));