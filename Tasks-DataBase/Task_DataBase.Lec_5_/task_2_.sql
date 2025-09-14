
CREATE  TABLE Doctor   
(
id NUMBER(12) CONSTRAINT ID_Doctor_PR_KEY PRIMARY KEY,
nameDoctor VARCHAR2(20) UNIQUE,
salary NUMBER(4) NOT NULL
);

DROP TABLE Doctor ;

-- ___________________________________________ //

CREATE  TABLE Patient   
(
id NUMBER(12) CONSTRAINT ID_Patient_PR_KEY PRIMARY KEY ,
namePatient VARCHAR2(20) ,
age NUMBER(3) 
);

DROP TABLE Patient ;

-- ___________________________________________ //

CREATE  TABLE Doctor_Patient   
(
id_Doctor NUMBER(12) NOT NULL,
id_Patient NUMBER(12)  NOT NULL,
CONSTRAINT ID_DOCTOR_FK FOREIGN KEY(id_Doctor) REFERENCES Doctor(id),
CONSTRAINT ID_PATIENT_FK FOREIGN KEY(id_Patient) REFERENCES Patient(id),
CONSTRAINT COMPOSOT_UK_NN  UNIQUE (id_Doctor , id_Patient)
);

DROP TABLE Doctor_Patient ;


