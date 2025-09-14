
CREATE  TABLE Employee     
(
id NUMBER(12) CONSTRAINT ID_Teacher_PR_KEY PRIMARY KEY,
name_employee VARCHAR2(20) NOT NULL UNIQUE  ,
age NUMBER(3) 
);

DROP TABLE Employee ;

-- ___________________________________________ //

CREATE  TABLE Phone     
(
id NUMBER(12) CONSTRAINT ID_Language_PR_KEY PRIMARY KEY ,
phoneNumber  NUMBER(12) NOT NULL UNIQUE  ,
id_employee NUMBER(12) UNIQUE NOT NULL ,
CONSTRAINT ID_Teacher_FK FOREIGN KEY(id_employee) REFERENCES Employee(id)
);

DROP TABLE Phone ;





