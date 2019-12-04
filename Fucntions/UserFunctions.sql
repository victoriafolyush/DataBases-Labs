	USE `cathedra`;

	DROP FUNCTION IF EXISTS seniorityAVG;
	DROP FUNCTION IF EXISTS findPossition;


	DELIMITER //
	CREATE FUNCTION  seniorityAVG ()
	RETURNS int
	READS SQL DATA
	DETERMINISTIC
	BEGIN
	RETURN (SELECT FLOOR(AVG((seniority))) FROM employee);
	END //
	DELIMITER ;

	DELIMITER //
	CREATE FUNCTION findPossition(position_id INT)
	RETURNS VARCHAR(45)
	READS SQL DATA
	DETERMINISTIC
	BEGIN
		RETURN (SELECT `position`.name FROM `position`, employee WHERE position_id = position.id GRoup By position_id);
	END //
	DELIMITER ;


	SELECT * FROM employee WHERE seniority > seniorityAVG();
	SELECT first_name, last_name, father_name, seniority, birth_date, seria_of_passport, number_of_passport, degree_id, academic_status_id, findPossition(position_id) FROM employee;