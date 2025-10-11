package University_Course_Management_System.service.Service_Impl;

import University_Course_Management_System.Mapper.Course_Mapper;
import University_Course_Management_System.dto.CourseDto;
import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Instructor;
import University_Course_Management_System.repository.CourseRepository;
import University_Course_Management_System.repository.InstructorRepository;
import University_Course_Management_System.service.Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Course_Service_Impl implements Course_Service {

    CourseRepository courseRepository;
    InstructorRepository instructorRepository;
    Course_Mapper course_Mapper;

    @Autowired
    Course_Service_Impl(CourseRepository courseRepository , InstructorRepository instructorRepository
    , Course_Mapper course_Mapper)
    {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.course_Mapper = course_Mapper;
    }

//________________________________________________________________________________



//_________________________ api To Add a new course _______________________________________________
//_________________________________________________________________________________________________
    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }




//_________________________ api To Get All Courses _______________________________________________
//_________________________________________________________________________________________________
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }




//_________________________ api To Assign Instructor To Course ____________________________________
//_________________________________________________________________________________________________
    @Override
    public Course asingInstructorToCourse(Long courseId, Long instructorId) {

        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        Course course1 = course.get();

        if(!course.isPresent() || !instructor.isPresent())
        {
            if(course.isPresent())
            {throw new RuntimeException("Instructor Not Found");}
            else
            { throw new RuntimeException("Course Not Found");}
        }

        course1.assign_An_Instructor_To_A_Course(instructor.get());

        return courseRepository.save(course1);
    }


//_________________________ api To Get Course With Id ____________________________________________
//_________________________________________________________________________________________________

    @Override
    public CourseDto getCourseWithId(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        return course_Mapper.toDto(course);
    }
}
