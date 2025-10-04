package com.springbootproject_1.service;

import com.springbootproject_1.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Teacher teacher);
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    void deleteTeacherById(Long id);

}
