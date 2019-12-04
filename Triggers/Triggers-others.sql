USE cathedra;

DROP TRIGGER IF EXISTS BeforeInsertEmployeeLastNameCheck;
DROP TRIGGER IF EXISTS BeforeUpdateEmployeeLastNameCheck;
DROP TRIGGER IF EXISTS BeforeInsertEmployeePassportCheck;
DROP TRIGGER IF EXISTS BeforeUpdateEmployeePassportCheck;
DROP TRIGGER IF EXISTS AfterInsertDisciplineCardinality;
DROP TRIGGER IF EXISTS AfterUpdateDisciplineCardinality;

DELIMITER //
CREATE TRIGGER BeforeInsertEmployeeLastNameCheck
BEFORE INSERT
ON `employee` FOR EACH ROW
FOLLOWS BeforeInsertEmployee
BEGIN
	IF (new.last_name RLIKE "вий$" || new.last_name RLIKE "ва$")
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Insert ERROR: last name cannot end with -вий or -ва";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateEmployeeLastNameCheck
BEFORE UPDATE
ON `employee` FOR EACH ROW
FOLLOWS BeforeUpdateEmployee
BEGIN
	IF (new.last_name RLIKE "вий$" || new.last_name RLIKE "ва$")
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Insert ERROR: last name cannot end with -вий or -ва";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertEmployeePassportCheck
BEFORE INSERT
ON `employee` FOR EACH ROW
FOLLOWS BeforeInsertEmployee
BEGIN
	IF (new.number_of_passport NOT RLIKE "^..[[:space:]][0-9][0-9][0-9][0-9][0-9][0-9]$")
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Insert ERROR: number of passport does not match the patter";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateEmployeePassportCheck
BEFORE UPDATE
ON `employee` FOR EACH ROW
FOLLOWS BeforeUpdateEmployee
BEGIN
	IF (new.number_of_passport NOT RLIKE "^..[[:space:]][0-9][0-9][0-9][0-9][0-9][0-9]$")
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Insert ERROR: number of passport does not match the patter";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterInsertDisciplineCardinality
AFTER INSERT
ON `discipline` FOR EACH ROW
BEGIN
	IF ((SELECT COUNT(*) FROM `discipline`) NOT BETWEEN 2 AND 6)
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Cardinality ERROR: allowed only between 2 and 6";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterUpdateDisciplineCardinality
AFTER INSERT
ON `discipline` FOR EACH ROW
BEGIN
	IF ((SELECT COUNT(*) FROM `discipline`) NOT BETWEEN 2 AND 6)
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Cardinality ERROR: allowed only between 2 and 6";
	END IF;
END //
DELIMITER ;

