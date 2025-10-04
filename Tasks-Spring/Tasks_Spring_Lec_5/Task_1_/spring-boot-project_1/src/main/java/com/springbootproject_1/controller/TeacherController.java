package com.springbootproject_1.controller;


import com.springbootproject_1.model.Teacher;
import com.springbootproject_1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    private TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/teacher/save")
    public Teacher saveTeacher(Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/teacher/update")
    public Teacher updateTeacher(Teacher teacher){
    return teacherService.updateTeacher(teacher);
    }


    @DeleteMapping("/teacher/delete")
    public void deleteTeacher(Long id){
        teacherService.deleteTeacherById(id);
    }


    @GetMapping("/teacher")
    public Teacher getTeachers(Teacher teacher){

        return teacherService.getTeacherById(teacher);
    }







}
