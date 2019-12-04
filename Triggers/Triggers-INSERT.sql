USE cathedra;

DROP TRIGGER IF EXISTS BeforeInsertDiscipline;
DROP TRIGGER IF EXISTS BeforeInsertDisciplineHasEmployee;
DROP TRIGGER IF EXISTS BeforeInsertEmployee;

DELIMITER //
CREATE TRIGGER BeforeInsertDiscipline
BEFORE INSERT
ON `discipline` FOR EACH ROW
BEGIN
	IF (new.acceptance_form_id NOT IN (SELECT id FROM `acceptance_form`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR:  foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertDisciplineHasEmployee
BEFORE INSERT
ON `discipline_has_employee` FOR EACH ROW
BEGIN
	IF (new.employee_id NOT IN (SELECT id FROM `employee`) || new.discipline_id NOT IN (SELECT id FROM `discipline`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR:  foreign key failure";
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER BeforeInsertEmployee
BEFORE INSERT
ON `employee` FOR EACH ROW
BEGIN
	IF (new.degree_id NOT IN (SELECT id FROM `degree`) || new.academic_status_id NOT IN (SELECT id FROM `academic_status`) || new.position_id NOT IN (SELECT id FROM `position`))
	THEN SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = ":( ERROR:  foreign key failure";
	END IF;
END //
DELIMITER ;
	
INSERT INTO discipline_has_employee (discipline_id, employee_id) VALUES (1, 1);
INSERT INTO discipline (name, semestr, kod, acceptance_form_id) VALUES ("matematika", "first", "kod1", 1 );