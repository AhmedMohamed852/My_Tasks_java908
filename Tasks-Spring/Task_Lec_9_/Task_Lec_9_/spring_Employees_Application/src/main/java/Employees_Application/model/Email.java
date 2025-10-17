package Employees_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Email {
//______________attributes_________________________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false )
    private String name;

    @Column(nullable = false)
    private String content;


//_______________relations__________________________________________
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee_E employee;
}
