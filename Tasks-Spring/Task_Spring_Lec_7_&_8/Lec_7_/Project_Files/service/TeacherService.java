package com.springbootproject_1.service;

import com.springbootproject_1.model.Teacher;
import dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TeacherService {

    List<TeacherDto> getAllTeachers();
    TeacherDto getTeacherById(long id) ;
    TeacherDto getTeacherByUsername(String username);
    TeacherDto addTeacher(TeacherDto teacher) ;
    TeacherDto updateTeacher(TeacherDto teacher) ;
    void deleteTeacherById(Long id);

}
