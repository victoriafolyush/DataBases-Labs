-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cathedra
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cathedra
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cathedra` DEFAULT CHARACTER SET utf8 ;
USE `cathedra` ;

-- -----------------------------------------------------
-- Table `cathedra`.`degree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`degree` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cathedra`.`academic_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`academic_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cathedra`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cathedra`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `father_name` VARCHAR(45) NULL,
  `seniority` VARCHAR(45) NULL,
  `birth_date` VARCHAR(45) NULL,
  `seria_of_passport` VARCHAR(45) NULL,
  `number_of_passport` VARCHAR(45) NULL,
  `degree_id` INT NOT NULL,
  `academic_status_id` INT NOT NULL,
  `position_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_degree1_idx` (`degree_id` ASC) VISIBLE,
  INDEX `fk_employee_academic_status1_idx` (`academic_status_id` ASC) VISIBLE,
  INDEX `fk_employee_position1_idx` (`position_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_degree1`
    FOREIGN KEY (`degree_id`)
    REFERENCES `cathedra`.`degree` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_academic_status1`
    FOREIGN KEY (`academic_status_id`)
    REFERENCES `cathedra`.`academic_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `cathedra`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cathedra`.`acceptance_form`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`acceptance_form` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cathedra`.`discipline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`discipline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `semestr` VARCHAR(45) NULL,
  `kod` VARCHAR(45) NULL,
  `acceptance_form_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_discipline_acceptance_form_idx` (`acceptance_form_id` ASC) VISIBLE,
  CONSTRAINT `fk_discipline_acceptance_form`
    FOREIGN KEY (`acceptance_form_id`)
    REFERENCES `cathedra`.`acceptance_form` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cathedra`.`discipline_has_employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cathedra`.`discipline_has_employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `discipline_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  INDEX `fk_discipline_has_employee_employee1_idx` (`employee_id` ASC) VISIBLE,
  INDEX `fk_discipline_has_employee_discipline1_idx` (`discipline_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_discipline_has_employee_discipline1`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `cathedra`.`discipline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discipline_has_employee_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `cathedra`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
