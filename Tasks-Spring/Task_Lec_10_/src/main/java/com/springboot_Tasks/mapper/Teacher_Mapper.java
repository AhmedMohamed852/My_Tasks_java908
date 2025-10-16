package com.springboot_Tasks.mapper;

import com.springboot_Tasks.dto.Teacher_Dto;
import com.springboot_Tasks.model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Teacher_Mapper {

    Teacher toEntity(Teacher_Dto teacherDto);
    Teacher_Dto toDto(Teacher teacher);

    List<Teacher_Dto> toDtoList(List<Teacher> teacherList);

}
