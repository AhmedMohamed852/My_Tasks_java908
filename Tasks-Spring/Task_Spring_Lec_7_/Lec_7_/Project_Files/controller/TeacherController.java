package com.springbootproject_1.controller;


import com.springbootproject_1.service.TeacherService;
import dto.TeacherDto;
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
    public List<TeacherDto> getTeachers(){
    return teacherService.getAllTeachers();
    }





    @PostMapping("/teacher/save")
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto){

        return teacherService.addTeacher(teacherDto);
    }






    @PutMapping("/teacher/update")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {
    return teacherService.updateTeacher(teacherDto);
    }






    @DeleteMapping("/teacher/delete")
    public void deleteTeacher(@RequestParam Long id)  {
    teacherService.deleteTeacherById(id);
    }






    @GetMapping("/teacher/by_id/{id}")
    public TeacherDto getTeacher(@PathVariable long id)  {

    return teacherService.getTeacherById(id);
    }






    @GetMapping("/teacher/by_username")
    public TeacherDto getTeacher(@RequestParam String username){

    return teacherService.getTeacherByUsername(username);
    }




}
