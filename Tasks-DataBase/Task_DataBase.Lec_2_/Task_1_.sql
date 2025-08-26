
CREATE TABLE Doctor (
id NUMBER(12), name VARCHAR(25) , salary NUMBER(7) , address VARCHAR(100)
);

INSERT INTO Doctor 
VALUES  ( 21956316 ,  'moaaz_Goda' ,  32000 ,  'new_giza');

SELECT * FROM Doctor;

UPDATE Doctor SET salary = 20000 WHERE name = 'Omar_MOhamed';

DELETE  Doctor WHERE name = 'mahmode_Goda';

SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'Ahmed_MOhamed';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'Yaser_MOhamed';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'Omar_MOhamed';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'Omar_Basem';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'yousef_Basem';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'momen_Basem';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'islame_asem';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'hosam_asem';
SELECT name || 'your_Salary_Is : ' || salary FROM Doctor WHERE name = 'moaaz_Goda';



SELECT name || ' your_Salary_Is: ' || salary AS info
FROM Doctor
WHERE name IN ('Ahmed_MOhamed', 'Yaser_MOhamed', 'Omar_MOhamed', 'Omar_Basem', 'yousef_Basem', 'momen_Basem', 'islame_asem', 'hosam_asem', 'moaaz_Goda')


SELECT id ,name ,salary*2 FROM Doctor ;

UPDATE Doctor 
SET salary = 1000 WHERE name = 'islame_asem';

UPDATE Doctor
SET salary = 2000 WHERE name = 'hosam_asem';

UPDATE Doctor 
SET salary = 3000 WHERE name = 'moaaz_Goda';

SELECT * FROM PRD_DOCTOR WHERE salary = 1000 OR salary = 2000 OR salary = 3000 ;

RENAME  Doctor TO  PRD_DOCTOR;

