USE cathedra;

DROP TRIGGER IF EXISTS BeforeDeleteDiscipline;
DROP TRIGGER IF EXISTS BeforeDeleteEmployee;
DROP TRIGGER IF EXISTS BeforeDeleteAcceptanceForm;
DROP TRIGGER IF EXISTS BeforeDeleteDegree;
DROP TRIGGER IF EXISTS BeforeDeleteAdemicStatus;
DROP TRIGGER IF EXISTS BeforeDeletePosition;


DELIMITER //
CREATE TRIGGER BeforeDeleteDiscipline
BEFORE DELETE
ON `discipline` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT discipline_id FROM `discipline_has_employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER BeforeDeleteEmployee
BEFORE DELETE
ON `employee` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT employee_id FROM `discipline_has_employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteAcceptanceForm
BEFORE DELETE
ON `acceptance_form` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT acceptance_form_id FROM `discipline`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteDegree
BEFORE DELETE
ON `degree` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT degree_id FROM `employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeleteAdemicStatus
BEFORE DELETE
ON `academic_status` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT academic_status_id FROM `employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeDeletePosition
BEFORE DELETE
ON `position` FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT position_id FROM `employee`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR: foreign key failure";
	END IF;
END //
DELIMITER ;

DELETE from position WHERE id = 1;