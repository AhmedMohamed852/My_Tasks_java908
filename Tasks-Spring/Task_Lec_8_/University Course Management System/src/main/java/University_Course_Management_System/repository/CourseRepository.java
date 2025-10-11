package University_Course_Management_System.repository;

import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

        List<Course> findByInstructor(Instructor instructor);
}
