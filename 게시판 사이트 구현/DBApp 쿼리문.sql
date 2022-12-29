-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema DBApp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DBApp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBApp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `DBApp` ;

-- -----------------------------------------------------
-- Table `DBApp`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBApp`.`Users` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `pwd` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `DBApp`.`posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBApp`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `replyCount` INT NULL DEFAULT '0',
  `userId` VARCHAR(20) NULL DEFAULT NULL,
  `postTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 517
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `DBApp`.`replys`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBApp`.`replys` (
  `replyId` INT NOT NULL AUTO_INCREMENT,
  `postId` INT NOT NULL,
  `writer` VARCHAR(30) NOT NULL,
  `content` TEXT NOT NULL,
  `replyTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`replyId`, `postId`),
  CONSTRAINT `replys_ibfk_1`
    FOREIGN KEY ()
    REFERENCES `DBApp`.`posts` ()
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
