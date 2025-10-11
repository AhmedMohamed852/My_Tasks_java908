package University_Course_Management_System.service.Service_Impl;

import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Instructor;
import University_Course_Management_System.repository.CourseRepository;
import University_Course_Management_System.repository.InstructorRepository;
import University_Course_Management_System.service.Instructor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class Instructor_Service_Impl implements Instructor_Service {
    private final InstructorRepository instructorRepository;

    private  final CourseRepository courserepository;


    @Autowired
    Instructor_Service_Impl(InstructorRepository instructorRepository , CourseRepository courserepository)
    {
        this.instructorRepository = instructorRepository;
        this.courserepository = courserepository;
    }



//_________________________ api To Add new instructor  ____________________________________________
//_________________________________________________________________________________________________

    @Override
    public Instructor saveInstructor(Instructor instructor)
    {
        return instructorRepository.save(instructor);
    }



//_________________________ api To Get All instructors  ____________________________________________
//_________________________________________________________________________________________________


        @Override
    public List<Instructor> getAllInstructors()
    {
        return instructorRepository.findAll();
    }



//_________________________ api To Get Courses By Instructor  _____________________________________
//_________________________________________________________________________________________________

        @Override
        public List<Course> getCoursesByInstructor(Long instructorId)
        {
            Instructor instructor=  instructorRepository.findById(instructorId).orElseThrow(() ->new RuntimeException());

            return courserepository.findByInstructor(instructor);
        }

        @Override
        public Instructor getInstructorWithId(Long id)
        {
            return instructorRepository.findById(id).orElseThrow(() ->new RuntimeException());
        }
    }
