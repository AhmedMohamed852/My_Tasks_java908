package University_Course_Management_System.dto;

import University_Course_Management_System.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
//______________________________ATTRIBUTES______________________________
//______________________________________________________________________

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;

//___________________RELATIONSHIPS______________________________________
//______________________________________________________________________


    List<Course> courses = new ArrayList<>();


//_______________________________________________________________________


    public void registerToCourse(Course course)
    {
        courses.add(course);
    }


}
