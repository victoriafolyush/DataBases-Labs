DROP PROCEDURE IF EXISTS proc_2;

DELIMITER ££
CREATE PROCEDURE proc_2 ()
BEGIN
    DECLARE rand int;
    DECLARE num int;
	set num = 0;
    first_while: WHILE num != 10 DO
		SET rand = FLOOR(RAND() * 1000);
		SET @newName = CONCAT('Noname№', rand);
		IF (@newName NOT IN (SELECT name FROM degree)) 
			THEN 
				INSERT INTO degree (name) VALUES (@newName);
				SET num = num + 1;
        END IF;
	END WHILE first_while;
END ££
DELIMITER ;

CALL proc_2();