package com.springboot_Tasks.controller;

import com.springboot_Tasks.dto.Student_Dto;
import com.springboot_Tasks.service.Student_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Student_Controller {

    Student_Service student_Service;
    @Autowired
    public Student_Controller(Student_Service student_Service) {
        this.student_Service = student_Service;
    }


    @PostMapping("/saveStudent")
    public ResponseEntity<Student_Dto> saveStudent(@RequestBody @Valid Student_Dto studentDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/saveStudent")).body(student_Service.saveStudent(studentDto));
    }


    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student_Dto>> getAllStudents()
    {
        return ResponseEntity.ok(student_Service.getAllStudents());
    }

    @GetMapping("/getListOfStudentsByIds")
    public ResponseEntity<List<Student_Dto>> getListOfStudentsByIds(@RequestParam List<Long> StudentIds)
    {
        return ResponseEntity.ok(student_Service.getListOfStudentsByIds(StudentIds));
    }
}
