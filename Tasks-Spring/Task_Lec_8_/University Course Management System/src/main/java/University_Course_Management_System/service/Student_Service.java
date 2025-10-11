package University_Course_Management_System.service;


import University_Course_Management_System.dto.StudentDto;
import University_Course_Management_System.model.Student;

import java.util.List;

public interface Student_Service {

    StudentDto saveStudent(StudentDto studentDto);

    List<StudentDto> getAllStudents();

    StudentDto getStudentWithById(Long id);

    StudentDto registerToCourse(Long studentId, Long courseId);
}
