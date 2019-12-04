USE cathedra;

DROP TRIGGER IF EXISTS BeforeUpdateDiscipline;
DROP TRIGGER IF EXISTS BeforeUpdateAcceptanceForm;
DROP TRIGGER IF EXISTS BeforeUpdateDegree;
DROP TRIGGER IF EXISTS BeforeUpdateAcademicStatus;
DROP TRIGGER IF EXISTS BeforeUpdatePosition;
DROP TRIGGER IF EXISTS BeforeUpdateEmployee;

DELIMITER //
CREATE TRIGGER BeforeUpdateDiscipline
BEFORE UPDATE
ON `discipline` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT discipline_id FROM `discipline_has_employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Update ERROR: foreign key failure";
	END IF;BeforeDeleteEmployee
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateAcceptanceForm
BEFORE UPDATE
ON `acceptance_form` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT acceptance_form_id FROM `discipline`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Update ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateDegree
BEFORE UPDATE
ON `degree` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT degree_id FROM `employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Update ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateAcademicStatus
BEFORE UPDATE
ON `academic_status` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT academic_status_id FROM `employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Update ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdatePosition
BEFORE UPDATE
ON `position` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT position_id FROM `employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Update ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeUpdateEmployee
BEFORE UPDATE
ON `employee` FOR EACH ROW
BEGIN
	IF (old.id != new.id AND old.id IN (SELECT employee_id FROM `discipline_has_employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( Update ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;