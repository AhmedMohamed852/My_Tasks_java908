package Employees_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Check(constraints = "age > 15 AND age <= 40")
@Check(constraints = "salary > 5000 AND salary <= 100000")
public class Employee_E {

//______________attributes_________________________________________

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String name;

    private int age;
    @Column(nullable = false)
    private double salary;

//______________relations_________________________________________
    @OneToMany(mappedBy = "employee")
    private java.util.List<Email> emails;



}
