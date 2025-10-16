package com.springboot_Tasks.mapper;

import com.springboot_Tasks.dto.Student_Dto;
import com.springboot_Tasks.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Student_Mapper {


    Student toEntity(Student_Dto studentDto);
    Student_Dto toDto(Student student);

    List<Student_Dto> toDtoList(List<Student> studentList);
}
