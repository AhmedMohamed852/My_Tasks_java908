package com.springboot_Tasks.service.impl;

import com.springboot_Tasks.dto.Teacher_Dto;
import com.springboot_Tasks.mapper.Teacher_Mapper;
import com.springboot_Tasks.model.Student;
import com.springboot_Tasks.model.Teacher;
import com.springboot_Tasks.repo.Student_Repo;
import com.springboot_Tasks.repo.Teacher_Repo;
import com.springboot_Tasks.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Teacher_Impl implements TeacherService {

   private final Teacher_Repo teacher_Repo;
   private final Student_Repo studentRepo;
   private final Teacher_Mapper teacher_Mapper;

   @Autowired
    Teacher_Impl(Teacher_Repo teacher_Repo , Student_Repo studentRepo , Teacher_Mapper teacher_Mapper)
    {
        this.teacher_Repo = teacher_Repo;
        this.studentRepo = studentRepo;
        this.teacher_Mapper = teacher_Mapper;
    }

    @Override
    public Teacher_Dto saveTeacher(Teacher_Dto teacherDto) {
       Optional<Teacher> teacher = teacher_Repo.findByusername(teacherDto.getUsername());
       if(teacher.isPresent())
       {
           throw new RuntimeException("Teacher already exists");
       }

       if(Objects.nonNull(teacherDto.getId()))
       {
           throw new RuntimeException("Teacher Id is not null");
       }

       teacher_Repo.save(teacher_Mapper.toEntity(teacherDto));
       return teacherDto;

    }

    @Override
    public Teacher_Dto teacher_Joins_Student(Long teacherId, Long studentId) {
       Optional<Teacher> teacher = teacher_Repo.findById(teacherId);
       Optional<Student> student = studentRepo.findById(studentId);

       if(!teacher.isPresent() || !student.isPresent())
       {
           throw new RuntimeException("Teacher or Student not found");
       }


       Student student1 = student.get();
      Teacher teacher1 =  teacher.get();

      teacher1.getStudents().add(student1);
      student1.getTeachers().add(teacher1);

        return  teacher_Mapper.toDto(teacher_Repo.save(teacher1));
    }

    @Override
    public List<Teacher_Dto> getAllTeachers() {
        return teacher_Mapper.toDtoList(teacher_Repo.findAll());
    }

    @Override
    public List<Teacher_Dto> getListOfTeachersByIds(List<Long> teacherIds) {

        return teacher_Mapper.toDtoList(teacher_Repo.findAllById(teacherIds));
    }
}
