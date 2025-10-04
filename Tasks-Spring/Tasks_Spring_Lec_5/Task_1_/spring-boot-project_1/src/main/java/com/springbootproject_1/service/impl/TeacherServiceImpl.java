package com.springbootproject_1.service.impl;

import com.springbootproject_1.model.Teacher;
import com.springbootproject_1.repo.TeacherRepo;
import com.springbootproject_1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private  TeacherRepo teacherRepo;
    @Autowired
    public TeacherServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }




    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher getTeacherById(Teacher teacher) {
       return teacher = teacherRepo.findById(teacher.getId()).get();
    }


    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
            teacherRepo.deleteById(id);
    }
}
