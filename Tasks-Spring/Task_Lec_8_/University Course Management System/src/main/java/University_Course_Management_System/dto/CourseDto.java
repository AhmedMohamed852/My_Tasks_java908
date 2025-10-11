package University_Course_Management_System.dto;
import University_Course_Management_System.model.Instructor;
import University_Course_Management_System.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CourseDto {
//______________________________ATTRIBUTES______________________________
//______________________________________________________________________


    private Long id;

    @NotBlank
    private String title;
    @NotBlank
    private String description;

//___________________RELATIONSHIPS______________________________________
//______________________________________________________________________

    List<Student> students = new ArrayList<>();

    private Instructor instructor;

    public void assign_An_Instructor_To_A_Course(Instructor instructor){
        this.instructor = instructor;
    }

}
