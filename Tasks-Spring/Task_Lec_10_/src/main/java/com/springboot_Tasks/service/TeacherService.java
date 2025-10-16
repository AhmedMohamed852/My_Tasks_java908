package com.springboot_Tasks.service;

import com.springboot_Tasks.dto.Teacher_Dto;
import com.springboot_Tasks.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher_Dto saveTeacher(Teacher_Dto teacherDto);

    Teacher_Dto teacher_Joins_Student(Long teacherId,Long studentId);

    List<Teacher_Dto> getAllTeachers();

    List<Teacher_Dto> getListOfTeachersByIds(List<Long> teacherIds);


}
