package spring_Tasks_Project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Doctor_Department_S" ,
uniqueConstraints = @jakarta.persistence.UniqueConstraint(columnNames = {"doctor_id" , "department_id"}) )

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctor_Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//____________ Relations ____________________________

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;


}
