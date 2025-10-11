package University_Course_Management_System.Controller;

import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Instructor;
import University_Course_Management_System.service.Instructor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Instructor_Controller {

     Instructor_Service instructor_Service;
    @Autowired
    public Instructor_Controller(Instructor_Service instructorService)
    { instructor_Service = instructorService; }


//_________________________ api To Add new instructor  ____________________________________________
//_________________________________________________________________________________________________
    @PostMapping("/saveInstructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor)
    {
        return instructor_Service.saveInstructor(instructor);
    }


//_________________________ api To Get All instructor  ____________________________________________
//_________________________________________________________________________________________________
    @GetMapping("/getAllInstructors")
public List<Instructor> getAllInstructors()
{
        return instructor_Service.getAllInstructors();
}


//_________________________ api To Get Courses By Instructor  _____________________________________
//_________________________________________________________________________________________________
    @GetMapping("/getCoursesByInstructorId/{id}")
    public List<Course> getAllCoursesByInstructorId(@PathVariable Long id)
    {
        return instructor_Service.getCoursesByInstructor(id);
    }



//_________________________ api To Get Instructor With Id  _______________________________________
//_________________________________________________________________________________________________

    @GetMapping("/getInstructorWithId/{id}")
    public Instructor getInstructorWithId(@PathVariable Long id)
    {
        return instructor_Service.getInstructorWithId(id);
    }




}
