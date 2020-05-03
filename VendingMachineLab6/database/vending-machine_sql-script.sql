CREATE DATABASE IF NOT EXISTS vending_machine_db;
USE vending_machine_db ;



DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS vending_machine;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS vending_machine_has_menu;
DROP TABLE IF EXISTS mechanic;
DROP TABLE IF EXISTS daily_report;
DROP TABLE IF EXISTS vending_machine_has_product;
DROP TABLE IF EXISTS daily_report_has_product;



CREATE TABLE IF NOT EXISTS location (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `number` VARCHAR(45) NULL,
  `x_coordinate` VARCHAR(45) NULL,
  `y_coordinate` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS vending_machine (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NULL,
  `is_empty` TINYINT(1) NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vending_machine_location1_idx` (`location_id` ASC),
  CONSTRAINT `fk_vending_machine_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `vending_machine_db`.`location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS manufacturer (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS menu (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_of_creation` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS product (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `size` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `type` VARCHAR(45),
  `expiration_date` DATE NULL,
  `menu_id` INT NOT NULL,
  `manufacturer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_manufacturer1_idx` (`manufacturer_id` ASC),
  INDEX `fk_product_menu1_idx` (`menu_id` ASC),
  CONSTRAINT `fk_product_manufacturer1`
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `vending_machine_db`.`manufacturer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_product_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `vending_machine_db`.`menu` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS vending_machine_has_menu (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vending_machine_id` INT NOT NULL,
  `menu_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vending_machine_has_menu_menu1_idx` (`menu_id` ASC),
  INDEX `fk_vending_machine_has_menu_vending_machine1_idx` (`vending_machine_id` ASC),
  CONSTRAINT `fk_vending_machine_has_menu_vending_machine1`
    FOREIGN KEY (`vending_machine_id`)
    REFERENCES `vending_machine_db`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_vending_machine_has_menu_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `vending_machine_db`.`menu` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS mechanic (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS daily_report (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_of_report` DATETIME(0) NULL,
  `currency_loaded_from` DOUBLE NULL,
  `quantity_product_loaded_from` DOUBLE NULL,
  `quantity_product_loaded_to` DOUBLE NULL,
  `mechanic_id` INT NOT NULL,
  `vending_machine_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_daily_report_mechanic1_idx` (`mechanic_id` ASC),
  INDEX `fk_daily_report_vending_machine1_idx` (`vending_machine_id` ASC),
  CONSTRAINT `fk_daily_report_mechanic1`
    FOREIGN KEY (`mechanic_id`)
    REFERENCES `vending_machine_db`.`mechanic` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_daily_report_vending_machine1`
    FOREIGN KEY (`vending_machine_id`)
    REFERENCES `vending_machine_db`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS vending_machine_has_product (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vending_machine_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `sold_time` TIME(0) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vending_machine_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_vending_machine_has_product_vending_machine1_idx` (`vending_machine_id` ASC),
  CONSTRAINT `fk_vending_machine_has_product_vending_machine1`
    FOREIGN KEY (`vending_machine_id`)
    REFERENCES `vending_machine_db`.`vending_machine` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_vending_machine_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `vending_machine_db`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS daily_report_has_product (
  `id` INT NOT NULL AUTO_INCREMENT,
  `daily_report_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity_product` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_daily_report_has_product_product1_idx` (`product_id` ASC),
  INDEX `fk_daily_report_has_product_daily_report1_idx` (`daily_report_id` ASC),
  CONSTRAINT `fk_daily_report_has_product_daily_report1`
    FOREIGN KEY (`daily_report_id`)
    REFERENCES `vending_machine_db`.`daily_report` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_daily_report_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `vending_machine_db`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



INSERT INTO location (id, 
						country, 
                        city, 
                        street, 
                        number, 
                        x_coordinate, 
                        y_coordinate)
	VALUES (1, 'Ukraine', 'Lviv', 'Stepana Bandery', '1', '49.8346853', '49.8346853'),
		   (2, 'Ukraine', 'Lviv', 'Acad. Saharova', '24', '49.841952', '24.0315921'),
		   (3, 'Ukraine', 'Lviv', 'Mykoly Lukasha', '2', '49.82758813322838', '24.01403725147247'),
		   (4, 'Ukraine', 'Lviv', 'Pekarska', '39', '49.837539598205005', '24.042892456054684'),
		   (5, 'Ukraine', 'Lviv', 'Listopadoviy Chynu', '5', '49.840276238057825', '24.020168781280518'),
		   (6, 'Ukraine', 'Lviv', 'Volodymyra Antonovycha', '2', '49.82711749864391', '23.993153572082516'),
		   (7, 'Ukraine', 'Lviv', 'Naukova', '49', '49.804632443065415', '23.990986347198486'),
		   (8, 'Ukraine', 'Lviv', 'Lubinska', '175', '49.49.81868336596181', '23.963075280189514'),
		   (9, 'Ukraine', 'Lviv', 'Horodotska', '2', '49.83199664955197', '23.975971341133114'),
		   (10,'Ukraine', 'Lviv', 'Ivana Bahryanoho', '26', '49.82953983366462', '23.97693157196045');
           
           
INSERT INTO vending_machine (id, 
								model,
								is_empty,
                                location_id)
	VALUES (1,'Dixie', true, 1),
		   (2,'Narco', false, 2),
		   (3,'Model 600E', false, 2),
		   (4,'Mountain', true, 3),
		   (5,'Model 501 ', false, 4),
		   (6,'Model S2D', false, 5),
		   (7,'Model B2B', true, 5),
		   (8,'Vendo Model', false, 6),
		   (9,'Model 501E Beach', false, 7),
		   (10,'Narco 873G USA Flag', false, 8);
           

INSERT INTO manufacturer (id,
							name,
                            country)
	VALUES  (1, 'Coca-Cola', 'USA'),
			(2, 'Pepsi', 'Egypt'),
			(3, 'Mars', 'UK'),
			(4, 'Lays', 'USA'),
			(5, 'Fritos', 'Mexico'),
			(6, 'Munchies', 'USA'),
			(7, 'Casa Sanchez', 'Mexico'),
			(8, 'Cheezies', 'Canada'),
			(9, 'Dinamita', 'Philippines'),
			(10, 'Hadji Bey', 'Turkish');
            
            
INSERT INTO menu (id, date_of_creation)
	VALUES 	(1, '2019-10-01'),
			(2, '2019-10-02'),
			(3, '2019-10-03'),
			(4, '2019-10-04'),
			(5, '2019-10-05'),
			(6, '2019-10-06'),
			(7, '2019-10-07'),
			(8, '2019-10-08'),
			(9, '2019-10-09'),
			(10, '2019-10-10');
            
            
INSERT INTO product (id,
						name, 
                        size, 
                        price, 
                        type, 
                        expiration_date, 
                        menu_id, 
                        manufacturer_id)
	VALUES  (1, 'Coca-Cola', '0.5 litres', 15.0, 'vanilla', '2020-10-01', 9, 1),
			(2, 'Coca-Cola', '1.0 litres', 20.0, 'classic', '2020-10-01', 9, 1),
			(3, 'Coca-Cola', '1.5 litres', 25.0, 'classic', '2020-11-01', 9, 1),
			(4, 'Coca-Cola', '2.0 litres', 30.0, 'classic', '2020-10-05', 10, 1),
			(5, 'Mars', 'small', 10.0, 'classic', '2020-10-01', 10, 3),
			(6, 'Mars', 'medium', 18.0, 'classic', '2020-12-01', 10, 3),
			(7, 'Mars', 'large', 27.0, 'classic', '2020-10-01', 9, 3),
			(8, 'Mars', 'double-king', 35.0, 'classic', '2020-07-01', 10, 3),
			(9, 'Lays', 'small', 15.0, 'bacon', '2020-08-04', 9, 4),
			(10, 'Lays', 'large', 35.0, 'sour cream & onion', '2020-06-01', 10, 4);
           
           
           
INSERT INTO vending_machine_has_menu (id, vending_machine_id, menu_id)
	VALUES  (1, 2, 9),
			(2, 2, 10),
			(3, 5, 9),
			(4, 5, 10),
			(5, 9, 9),
			(6, 9, 10),
			(7, 3, 9),
			(8, 3, 10),
			(9, 8, 9),
			(10, 8, 10);


INSERT INTO mechanic (id,
						first_name, 
                        last_name)
	VALUES  (1, 'Ihor', 'Stanko'),
			(2, 'Oleg', 'Dilnyy'),
			(3, 'Constantin', 'Rybak'),
			(4, 'Andrii', 'Terleckiy'),
			(5, 'Evgen', 'Bufan'),
			(6, 'Taras', 'Kulian'),
			(7, 'Michal', 'Radovych'),
			(8, 'Vitaliy', 'Pshtyr'),
			(9, 'Stephan', 'Krukynyckiy'),
			(10, 'Dima', 'Shevchenko');

INSERT INTO daily_report (id, 
							time_of_report, 
                            currency_loaded_from, 
                            quantity_product_loaded_from, 
                            quantity_product_loaded_to, 
                            mechanic_id,
                            vending_machine_id)
	VALUES (1, '2019-09-01 19:00:01', 315.0, 1.0, 7.0, 1, 2),
		   (2, '2019-09-02 19:01:12', 235.0, 0.0, 9.0, 2, 2),
		   (3, '2019-09-03 19:02:13', 246.0, 0.0, 8.0, 6, 2),
		   (4, '2019-09-01 19:01:06', 278.0, 3.0, 7.0, 3, 5),
		   (5, '2019-09-02 19:02:42', 278.0, 0.0, 9.0, 3, 5),
		   (6, '2019-09-03 19:01:11', 268.0, 6.0, 6.0, 2, 5),
		   (7, '2019-09-04 19:01:05', 289.0, 0.0, 8.0, 1, 5),
		   (8, '2019-09-04 19:05:02', 279.0, 8.0, 9.0, 6, 2),
		   (9, '2019-09-05 19:03:07', 289.0, 9.0, 8.0, 5, 2),
		   (10, '2019-09-06 19:03:03', 280.0, 0.0, 8.0, 5, 2);



INSERT INTO vending_machine_has_product (id,
											vending_machine_id, 
                                            product_id, 
                                            sold_time)
	VALUES  (1, 2, 1, '09:00:01.0035060'),
			(2, 2, 1, '09:50:01.0325060'),
			(3, 2, 1, '09:51:05.0435060'),
			(4, 2, 1, '09:51:15.0255060'),
			(5, 2, 1, '10:02:05.0445720'),
			(6, 2, 1, '10:23:45.0596460'),
			(7, 2, 1, '10:45:34.0035060'),
			(8, 2, 1, '11:12:23.0033460'),
			(9, 2, 1, '11:56:45.0036760'),
			(10, 2, 1, '12:25:14.0135060');
			
            
            
INSERT INTO daily_report_has_product (id, daily_report_id, product_id, quantity_product)
	VALUES  (1, 1, 1, 10),
			(2, 1, 2, 5),
			(3, 3, 3, 3),
			(4, 4, 4, 6),
			(5, 5, 5, 3),
			(6, 6, 6, 7),
			(7, 7, 7, 14),
			(8, 8, 8, 5),
			(9, 9, 9, 13),
			(10, 10, 10, 15);