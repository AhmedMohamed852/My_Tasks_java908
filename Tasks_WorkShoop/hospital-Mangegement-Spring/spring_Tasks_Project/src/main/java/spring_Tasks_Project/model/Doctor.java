package spring_Tasks_Project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Doctor_S")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String first_name;

    private String last_name;
    private String specialization;
    private String phone;
    private Double salary;
//____________ Relations ____________________________

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL)
    private List<Doctor_Patient> doctor_patient ;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL)
    private List<Doctor_Department> doctor_department ;








}
