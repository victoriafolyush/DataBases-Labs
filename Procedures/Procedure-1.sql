USE cathedra;
DELIMITER $$

DROP PROCEDURE IF EXISTS proc_1;
DROP PROCEDURE IF EXISTS proc_2;

CREATE PROCEDURE proc_1
(
	IN first_name VARCHAR(45),
	IN last_name VARCHAR(45),
	IN father_name VARCHAR(45),
	IN seniority varchar(45),
	IN birth_date VARCHAR(45), 
	IN seria_of_passport VARCHAR(45),
	IN number_of_passport VARCHAR(45),
	IN degree_id INT,
	IN academic_status_id INT,
	IN position_id INT
)
BEGIN
	INSERT INTO employee (first_name, last_name, father_name, seniority, birth_date, seria_of_passport, number_of_passport, degree_id, academic_status_id, position_id)
	VALUES (first_name, last_name, father_name, seniority, birth_date, seria_of_passport, number_of_passport, degree_id, academic_status_id, position_id);
END $$
DELIMITER ;

CALL proc_1("Jon3", "Black2", "Olegovych2", "5", "11.11.1928", "12445728", "3254658769783362", 2, 1, 2);