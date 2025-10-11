package University_Course_Management_System.Controller;

import University_Course_Management_System.dto.CourseDto;
import University_Course_Management_System.model.Course;
import University_Course_Management_System.service.Course_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Course_Controller {

    private Course_Service course_Service;
    @Autowired
    public Course_Controller(Course_Service course_Service)
    {
        this.course_Service = course_Service;
    }

//_________________________________________________________________________________________________



//_________________________ api To Add a new course _______________________________________________
//_________________________________________________________________________________________________
    @PostMapping("/saveCourse")
    public Course saveCourse(@RequestBody @Valid Course course)
    {
        return course_Service.saveCourse(course);
    }




//_________________________ api To Get All Courses _______________________________________________
//_________________________________________________________________________________________________
    @GetMapping("/getAllCourses")
    public List<Course> getAllCourses()
    {
        return course_Service.getAllCourses();
    }


//_________________________ api To Assign Instructor To Course ____________________________________
//_________________________________________________________________________________________________

    @PostMapping("/assignInstructor/{instructorId}/ToCourse/{courseId}")
    public Course assignInstructorToCourse(@PathVariable Long courseId ,@PathVariable Long instructorId)
    {
        return course_Service.asingInstructorToCourse(courseId , instructorId);
    }


//_________________________ api To Get Course With Id ____________________________________________
//_________________________________________________________________________________________________

    @GetMapping("/getCourse/{id}")
    public CourseDto getCourseWithId(@PathVariable Long id)
    {
        return course_Service.getCourseWithId(id);
    }





}
