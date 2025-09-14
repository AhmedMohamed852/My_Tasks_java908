DROP TABLE Manger ;


CREATE  TABLE Player 
(
id NUMBER(12) CONSTRAINT ID_NN_UK NOT NULL UNIQUE,
name VARCHAR2(20) CONSTRAINT NAME_UK UNIQUE,
age NUMBER(3) 
);
DROP TABLE Player ;

-- ___________________________________________ //

CREATE  TABLE Manger  
(
id NUMBER(12) CONSTRAINT ID_NN NOT NULL ,
name VARCHAR2(20),
salary NUMBER(3) ,
 CONSTRAINT NAME_AND_ID_UK UNIQUE(id , name)
);
DROP TABLE Manger ;

-- ___________________________________________ //

CREATE  TABLE Manger  
(
id NUMBER(12) CONSTRAINT ID_PR_KEY PRIMARY KEY ,
name VARCHAR2(20),
age NUMBER(3) 
);
DROP TABLE Manger ;

-- ___________________________________________ //
CREATE  TABLE Manger  
(
id NUMBER(12) CONSTRAINT ID_PR_KEY PRIMARY KEY ,
name VARCHAR2(20),
age NUMBER(3) 
);
DROP TABLE Manger ;

-- ___________________________________________ 
