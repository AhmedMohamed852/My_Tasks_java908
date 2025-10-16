package com.springboot_Tasks.service;

import com.springboot_Tasks.dto.Student_Dto;
import com.springboot_Tasks.model.Student;
import com.springboot_Tasks.model.Teacher;

import java.util.List;

public interface Student_Service {

    Student_Dto saveStudent(Student_Dto student);


    List<Student_Dto> getAllStudents();

    List<Student_Dto> getListOfStudentsByIds(List<Long> StudentIds);
}
