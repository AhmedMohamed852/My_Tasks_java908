package University_Course_Management_System.service;

import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Instructor;

import java.util.List;

public interface Instructor_Service {

    Instructor saveInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    List<Course> getCoursesByInstructor(Long instructorId);

    Instructor getInstructorWithId(Long id);


}
