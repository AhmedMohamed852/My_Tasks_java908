package spring_Tasks_Project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_Tasks_Project.gender.Gender;

import java.util.List;

@Entity(name = "Patient_S")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;
    private String address;

//____________ Relations ____________________________

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL)
    private List<Doctor_Patient> doctor_patient;
}
