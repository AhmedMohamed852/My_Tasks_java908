package com.springboot_Tasks.controller;

import com.springboot_Tasks.dto.Teacher_Dto;
import com.springboot_Tasks.model.Teacher;
import com.springboot_Tasks.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Teacher_Controller {

    TeacherService teacherService;
    @Autowired
    public Teacher_Controller(TeacherService teacherService) {
        this.teacherService = teacherService;
    }



    @PostMapping("/saveTeacher")
    public Teacher_Dto saveTeacher(@RequestBody @Valid Teacher_Dto teacher_Dto)
    {
       return teacherService.saveTeacher(teacher_Dto);
    }

    @PostMapping("/teacherJoinsStudent/{teacherId}/{studentId}")
    public Teacher_Dto teacher_Joins_Student(@PathVariable Long teacherId,@PathVariable Long studentId)
    {
        return teacherService.teacher_Joins_Student(teacherId,studentId);
    }



    @GetMapping("/getAllTeachers")
    public List<Teacher_Dto> getAllTeachers()
    {
        return teacherService.getAllTeachers();
    }


    @GetMapping("/getListOfTeachersByIds")
    public List<Teacher_Dto> getListOfTeachersByIds(@RequestParam List<Long> teacherIds)
    {
        return teacherService.getListOfTeachersByIds(teacherIds);
    }


}
