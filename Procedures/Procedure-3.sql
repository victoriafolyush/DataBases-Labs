DROP TABLE IF EXISTS newTable;
DROP TABLE IF EXISTS newtable;
DROP TABLE IF EXISTS newtable2;


DROP PROCEDURE IF EXISTS proc_3;

DELIMITER ££
CREATE PROCEDURE proc_3()
BEGIN
	DECLARE done int DEFAULT false;
    DECLARE position_name varchar(30);
    DECLARE tables_name varchar (100);
    
	DECLARE cursor_for_position CURSOR FOR SELECT position.name FROM position;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;

	OPEN cursor_for_position;
	set @temp_query = 'CREATE TABLE newtable2 (id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY (`id`))';
	PREPARE myquery2 FROM @temp_query;
	EXECUTE myquery2;
	DEALLOCATE PREPARE myquery2;
	myLoop: LOOP
    	FETCH cursor_for_position INTO position_name;
        IF done=true THEN LEAVE myLoop;
		END IF;
        
        set tables_name = CONCAT(position_name, " VARCHAR(45);" );
        set @pavelchak = CONCAT('ALTER TABLE newtable2 ADD ', tables_name);
        
		PREPARE myquery FROM @pavelchak;
		EXECUTE myquery;
		DEALLOCATE PREPARE myquery;
        
		END LOOP myLoop;
        
		DROP TABLE IF EXISTS newtable;
		CLOSE cursor_for_position;
        
        END ££
DELIMITER ;

CALL proc_3();
