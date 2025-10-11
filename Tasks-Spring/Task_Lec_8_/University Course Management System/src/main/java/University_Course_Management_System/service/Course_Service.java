package University_Course_Management_System.service;

import University_Course_Management_System.dto.CourseDto;
import University_Course_Management_System.model.Course;

import java.util.List;

public interface Course_Service {

    Course saveCourse(Course course);

    List<Course> getAllCourses();

    Course asingInstructorToCourse(Long courseId, Long instructorId);

    CourseDto getCourseWithId(Long id);


}
