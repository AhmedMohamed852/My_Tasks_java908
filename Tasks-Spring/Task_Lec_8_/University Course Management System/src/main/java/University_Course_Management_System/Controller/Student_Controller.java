package University_Course_Management_System.Controller;

import University_Course_Management_System.dto.StudentDto;
import University_Course_Management_System.model.Student;
import University_Course_Management_System.service.Student_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.bind.annotation.*;

@RestController
public class Student_Controller {

    private final Student_Service student_Service;
    @Autowired
    public Student_Controller(Student_Service student_Service)
    {
        this.student_Service = student_Service;
    }



//_________________________ api To Add new Student _______________________________________________
//_________________________________________________________________________________________________


    @PostMapping("/saveStudent")
    public StudentDto saveStudent(@RequestBody @Valid StudentDto studentDto)
    {
        return student_Service.saveStudent(studentDto);
    }


//_________________________ api To Get All Students _______________________________________________
//_________________________________________________________________________________________________

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents()
    {
        return student_Service.getAllStudents();
    }


//_________________________ api To Get Student By ID ______________________________________________
//_________________________________________________________________________________________________

    @GetMapping("/getStudentById/{id}")
    public StudentDto getStudentById(@PathVariable Long id)
    {
        return student_Service.getStudentWithById(id);
    }


//_________________________ api To Register a Student To a Course _________________________________
//_________________________________________________________________________________________________

    @PostMapping("/student/{studentId}/register/{courseId}")
    public StudentDto registerToCourse(@PathVariable Long studentId , @PathVariable Long courseId)
    {
        return student_Service.registerToCourse(studentId , courseId);
    }



}
