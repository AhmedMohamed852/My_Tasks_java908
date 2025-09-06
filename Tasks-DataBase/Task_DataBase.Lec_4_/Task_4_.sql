CREATE TABLE STUDENTS (name varchar(20) , marks number(3));
INSERT INTO STUDENTS (name , marks)
VALUES ('Mohamed' , 90 );

	SELECT name , marks , CASE 
	WHEN marks >= 90 THEN 'A'
	WHEN marks >= 80 THEN 'B'
	WHEN marks >= 70 THEN 'C'
	ELSE 'F'
	END  AS grades FROM STUDENTS ORDER BY GRADES;