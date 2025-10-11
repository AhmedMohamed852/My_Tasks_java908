package University_Course_Management_System.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
//______________________________ATTRIBUTES______________________________
//______________________________________________________________________

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title" ,unique = true , nullable = false)
    private String title;

    @Column(name = "description" ,nullable = false)
    private String description;

//___________________RELATIONSHIPS______________________________________
//______________________________________________________________________

    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id"  , unique = true)
    @JsonIgnore
    private Instructor instructor;

    public void assign_An_Instructor_To_A_Course(Instructor instructor){
        this.instructor = instructor;
    }

}
