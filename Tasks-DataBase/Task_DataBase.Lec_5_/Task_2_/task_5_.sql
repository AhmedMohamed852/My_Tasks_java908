
CREATE  TABLE Teacher    
(
id NUMBER(12) CONSTRAINT ID_Teacher_PR_KEY PRIMARY KEY,
name_teachar VARCHAR2(20) NOT NULL UNIQUE  ,
salary NUMBER(4) NOT NULL
);

DROP TABLE Doctor ;

-- ___________________________________________ //

CREATE  TABLE Language    
(
id NUMBER(12) CONSTRAINT ID_Language_PR_KEY PRIMARY KEY ,
name_language  VARCHAR2(20) NOT NULL ,
id_teacher NUMBER(12) UNIQUE,
CONSTRAINT ID_Teacher_FK FOREIGN KEY(id_teacher) REFERENCES Teacher(id)
);

DROP TABLE Language ;





