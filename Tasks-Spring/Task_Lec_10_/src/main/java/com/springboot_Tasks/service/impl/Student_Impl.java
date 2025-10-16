package com.springboot_Tasks.service.impl;

import com.springboot_Tasks.dto.Student_Dto;
import com.springboot_Tasks.mapper.Student_Mapper;
import com.springboot_Tasks.model.Student;
import com.springboot_Tasks.repo.Student_Repo;
import com.springboot_Tasks.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Student_Impl implements Student_Service {

   private final Student_Repo student_Repo;
   private final Student_Mapper student_Mapper;

    @Autowired
    Student_Impl(Student_Repo student_Repo , Student_Mapper student_Mapper)
    {
        this.student_Repo = student_Repo;
        this.student_Mapper = student_Mapper;
    }

    @Override
    public Student_Dto saveStudent(Student_Dto studentDto) {
        Optional<Student> student1 = student_Repo.findByusername(studentDto.getUsername());
        if(student1.isPresent())
        {
            throw new RuntimeException("Student already exists");
        }
        if(Objects.nonNull(studentDto.getId()))
        {
            throw new RuntimeException("Student Id is not null");
        }
        return student_Mapper.toDto(student_Repo.save(student_Mapper.toEntity(studentDto)));
    }

    @Override
    public List<Student_Dto> getAllStudents() {
        return student_Mapper.toDtoList(student_Repo.findAll());
    }

    @Override
    public List<Student_Dto> getListOfStudentsByIds(List<Long> StudentIds) {
        return student_Mapper.toDtoList(student_Repo.findAllById(StudentIds));
    }
}
