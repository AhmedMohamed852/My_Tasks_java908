package University_Course_Management_System.model;


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
public class Instructor {
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

    @OneToMany(mappedBy = "instructor")

    List<Course> courses = new ArrayList<>();



}
