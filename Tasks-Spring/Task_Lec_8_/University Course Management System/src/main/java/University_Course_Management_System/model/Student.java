package University_Course_Management_System.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Student {
//______________________________ATTRIBUTES______________________________
//______________________________________________________________________

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "email" , nullable = false)
    private String email;

//___________________RELATIONSHIPS______________________________________
//______________________________________________________________________

    @ManyToMany
    @JoinTable
    (name = "student_course" , joinColumns = @JoinColumn(name = "student_id") ,
    inverseJoinColumns = @JoinColumn(name = "course_id"), uniqueConstraints = @UniqueConstraint(columnNames = {"student_id","course_id"})
    )
    @JsonIgnore
    List<Course> courses = new ArrayList<>();


//_______________________________________________________________________


     public void registerToCourse(Course course)
     {
        courses.add(course);
    }


}
