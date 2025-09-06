
SELECT REPLACE('database' , 'a' ,'@') trim FROM dual;
SELECT REPLACE('This is the old text', 'old', 'new') trim FROM dual;

CREATE TABLE PRODUCT (product_name varchar(25));
INSERT INTO PRODUCT (product_name )
VALUES ('product_3')

SELECT LPAD(product_name ,15 ,'*') FROM PRODUCT;
SELECT RPAD(product_name ,15 ,'#') FROM PRODUCT;


