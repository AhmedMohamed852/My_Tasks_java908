package com.hibernate.model.teasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    
  @OneToOne
  @JoinColumn(name = "student_id",nullable = false ,unique = true)
  Student student ;


public String getNumber() {
	return number;
}


public void setNumber(String number) {
	this.number = number;
}


public Student getStudent() {
	return student;
}


public void setStudent(Student student) {
	this.student = student;
}
  

}
