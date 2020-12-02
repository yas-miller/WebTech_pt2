-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hacs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hacs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hacs` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hacs` ;

-- -----------------------------------------------------
-- Table `hacs`.`tenant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`tenant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hacs`.`petition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`petition` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `express_service_id` INT NULL DEFAULT NULL,
  `scale_work_id` INT NULL DEFAULT NULL,
  `time` BIGINT(10) NULL DEFAULT NULL,
  `tenant_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hacs`.`work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`work` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` BIGINT(10) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `petition_id` INT NULL DEFAULT NULL,
  `brigade_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hacs`.`brigade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`brigade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hacs`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `utility_worker_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hacs`.`express_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`express_service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `express_service` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hacs`.`utility_worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`utility_worker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `worker` VARCHAR(45) NULL DEFAULT NULL,
  `time_for_work` BIGINT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hacs`.`scale_work`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacs`.`scale_work` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `size` VARCHAR(45) NULL DEFAULT NULL,
  `scale_of_work` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
