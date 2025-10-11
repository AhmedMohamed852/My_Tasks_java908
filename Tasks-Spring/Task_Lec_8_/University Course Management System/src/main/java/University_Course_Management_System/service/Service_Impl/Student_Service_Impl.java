package University_Course_Management_System.service.Service_Impl;

import University_Course_Management_System.Mapper.Course_Mapper;
import University_Course_Management_System.Mapper.Student_Mapper;
import University_Course_Management_System.dto.StudentDto;
import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Student;
import University_Course_Management_System.repository.CourseRepository;
import University_Course_Management_System.repository.StudentRepository;
import University_Course_Management_System.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student_Service_Impl implements Student_Service {

    StudentRepository studentRepository;
    CourseRepository courseRepository;
    Student_Mapper student_Mapper;
    Course_Mapper course_Mapper;
    @Autowired
    Student_Service_Impl(StudentRepository studentRepository , CourseRepository courseRepository ,
                         Student_Mapper student_Mapper , Course_Mapper course_Mapper){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.student_Mapper = student_Mapper;
        this.course_Mapper = course_Mapper;
    }

//_______________________________________________________________________


//_________________________ api To Save a StudentDto _________________________________________________
//_________________________________________________________________________________________________
    @Override
    public StudentDto saveStudent(StudentDto studentDto) {


        studentRepository.save(student_Mapper.toEntity(studentDto));
        return studentDto;
    }




//_________________________ api To Get All Students _______________________________________________
//_________________________________________________________________________________________________

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> student = studentRepository.findAll();
        return student_Mapper.toDtoList(student);

    }


//_________________________ api To Get StudentDto By ID ______________________________________________
//_________________________________________________________________________________________________

    @Override
    public StudentDto getStudentWithById(Long id) {
        Optional<Student> student= studentRepository.findById(id);

        if(!student.isPresent())
        {
            throw new RuntimeException("StudentDto Not Found");
        }
        return student_Mapper.toDto(student.get());
    }



//_________________________ api To Register a StudentDto To a Course _________________________________
//_________________________________________________________________________________________________
    @Override
    public StudentDto registerToCourse(Long studentId, Long courseId)
    {

        Optional<Student> student= studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);

        Student student1 = student.get();

        if(student.isPresent() && course.isPresent())
        {
            student1.registerToCourse(course.get());
             studentRepository.save(student1);
             return student_Mapper.toDto(student1);
        }

        else
        {
            throw new RuntimeException("StudentDto or Course Not Found");
        }

    }

}
