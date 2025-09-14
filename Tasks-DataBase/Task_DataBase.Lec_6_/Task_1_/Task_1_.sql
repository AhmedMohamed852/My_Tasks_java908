-- ✅ 1. CHECK Constraint (Code Samples)
--___________________________________________________
CREATE TABLE EMPLOYEES_COPY (
age number(3) NOT NULL ,
CONSTRAINT AGE_MORE_THAN_18 CHECK(age > 18)

-- test >
-- SALARY number(7)
);

DROP TABLE EMPLOYEES_COPY;
--____________________________
	
ALTER TABLE EMPLOYEES_COPY ADD CONSTRAINT SAL_BETWEEN_3000_A_10000 CHECK(SALARY BETWEEN 3000 AND 10000 );

--____________________________

CREATE TABLE Students  (
grade  VARCHAR2(1) ,
CONSTRAINT grade_MORE_THAN_A_AND_F CHECK(grade IN('A' , 'B' ,'C' ,'D' ,'E' ,'F') )

);

INSERT INTO Students 
VALUES ('G');
--________________________________________________________
--🛠️ 2. Adding Constraints via ALTER TABLE (Code Samples)
--________________________________________________________

ALTER TABLE employees MODIFY EMAIL CONSTRAINT EMAIL_NN NOT NULL;

--____________________________

CREATE TABLE Users (
    id NUMBER PRIMARY KEY,
    username VARCHAR2(50),
    password VARCHAR2(50)
);
ALTER TABLE Users ADD CONSTRAINT USERNAME_UK UNIQUE (username);
DROP TABLE USERS;
--____________________________

ALTER TABLE Orders ADD CONSTRAINT ORDERS_COUSTMER_FK FOREIGN KEY (customer_id) REFERENCES Customers(id);
--____________________________

ALTER TABLE Accounts ADD CONSTRAINT BALANCE_MORE_THAN_0 CHECK(balance > 0);
--____________________________

ALTER TABLE Departments  ADD CONSTRAINT dept_id_pk PRIMARY KEY(DEPARTMENT_ID);

--________________________________________________________
--❌ 3. Dropping (Removing) Constraints (Code Samples)
--________________________________________________________

ALTER TABLE Employees   DROP CONSTRAINT chk_salary
--____________________________

ALTER TABLE Users  DROP CONSTRAINT USERNAME_UK;
--____________________________

ALTER TABLE Products   DROP CONSTRAINT ID_PK;
--____________________________

ALTER TABLE Orders   DROP CONSTRAINT fk_order_customer ;
--____________________________
--____________________________

ALTER TABLE EMPLOYEES_COPY  MODIFY  (age NULL) ;
--________________________________________________________
--✏️ 4. Renaming Constraints (Code Samples)
--________________________________________________________

ALTER TABLE students RENAME CONSTRAINT chk_age TO check_min_age ;
--____________________________

ALTER TABLE employees RENAME CONSTRAINT fk_emp_dept   TO fk_employee_department  ;
--____________________________

ALTER TABLE USERS RENAME CONSTRAINT SYS_C007946   TO pk_users_id  ;

--____________________________	

ALTER TABLE USERS RENAME CONSTRAINT USERNAME_UK TO uk_user_name;
--____________________________

EXEC sp_rename 'USERS.uk_user_name', 'USERNAME_UK';

--________________________________________________________
--🚫 5. Disabling Constraints (Code Samples)
--________________________________________________________

CREATE TABLE Customers (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(50)
);

CREATE TABLE Orders (
    order_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    CONSTRAINT fk_customer_order FOREIGN KEY (customer_id)
        REFERENCES Customers(id)
);

ALTER TABLE orders DISABLE CONSTRAINT fk_customer_order;
DROP TABLE Orders;
DROP TABLE Customers;

--____________________________
CREATE TABLE Products (
    product_id     NUMBER(10),
    product_name   VARCHAR2(100) NOT NULL,
    price          NUMBER(10,2),
    quantity       NUMBER(5),

    -- 🔑 القيود
    CONSTRAINT pk_products PRIMARY KEY (product_id),             -- Primary Key
    CONSTRAINT uq_product_name UNIQUE (product_name),            -- Unique
    CONSTRAINT chk_price CHECK (price > 0),                      -- Check
    CONSTRAINT chk_quantity CHECK (quantity >= 0)                -- Check
);

SELECT constraint_name
FROM user_constraints
WHERE table_name = 'PRODUCTS';

ALTER TABLE PRODUCTS DISABLE CONSTRAINT pk_products;
ALTER TABLE PRODUCTS DISABLE CONSTRAINT uq_product_name;
ALTER TABLE PRODUCTS DISABLE CONSTRAINT chk_price;
ALTER TABLE PRODUCTS DISABLE CONSTRAINT chk_quantity;

DROP TABLE Products;

--____________________________

ALTER TABLE ACCOUNTS DISABLE CONSTRAINT balance_more_than_0;
--____________________________
-- I can't delete this constraint. I deleted all FK from employees but it's not working.pl tell me 
ALTER TABLE EMPLOYEES ENABLE CONSTRAINT EMP_DEPT_FK;
ALTER TABLE DepartmentS DISABLE CONSTRAINT DEPT_ID_PK;
--____________________________
--____________________________

SELECT * FROM 	ACCOUNTS;
--____________________________
--How would you disable all constraints on a table before bulk inserting data?

ALTER TABLE your_table_name ENABLE CONSTRAINT ALL;

-- But Its not found in Orcal
--________________________________________________________
--✅ 6. Enabling Constraints (Code Samples)
--________________________________________________________

ALTER TABLE orders ENABLE CONSTRAINT fk_customer_order ;

--____________________________
ALTER TABLE PRODUCTS ENABLE CONSTRAINT pk_products;
ALTER TABLE PRODUCTS ENABLE CONSTRAINT uq_product_name;
ALTER TABLE PRODUCTS ENABLE CONSTRAINT chk_price;
ALTER TABLE PRODUCTS ENABLE CONSTRAINT chk_quantity;
--____________________________

--Enable the PRIMARY KEY constraint on Departments(dept_id) after it was disabled.
-- I can't delete this constraint. I deleted all FK from employees but it's not working.pl tell me 

--____________________________

-- ALTER TABLE table_Name ENABLE CONSTRAINT name_Constraint;

--____________________________
--____________________________


DROP TABLE Users;

SELECT * FROM EMPLOYEES   ;