CREATE TABLE manger (
id NUMBER(11) , name VARCHAR(50) , age NUMBER(3) ,birth_date DATE , address VARCHAR(50) 
);

SELECT * FROM manger;

ALTER TABLE manger DROP COLUMN address;

SELECT * FROM manger;

ALTER TABLE manger ADD (city_address VARCHAR(50) , streeT VARCHAR(50));

SELECT * FROM manger;

ALTER TABLE manger RENAME COLUMN name TO full_name ;

SELECT * FROM manger;

 ALTER TABLE manger READ ONLY;
 
 CREATE TABLE Owner AS SELECT id ,full_name ,birth_date FROM manger;
 
 SELECT * FROM Owner;
 
RENAME	Owner TO master;

 SELECT * FROM master;
 
 DROP TABLE manger;
 DROP TABLE master;
 
-- =======> THNK FOR YOU <======= --





