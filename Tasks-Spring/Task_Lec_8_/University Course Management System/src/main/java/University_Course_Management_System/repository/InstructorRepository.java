package University_Course_Management_System.repository;

import University_Course_Management_System.model.Course;
import University_Course_Management_System.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface InstructorRepository extends JpaRepository<Instructor, Long> {


}
