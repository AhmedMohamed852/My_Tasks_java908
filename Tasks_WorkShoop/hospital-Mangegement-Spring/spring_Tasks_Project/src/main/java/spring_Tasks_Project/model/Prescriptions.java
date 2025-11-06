package spring_Tasks_Project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Prescriptions_S")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prescriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

//______________________________ Relations ________________________________

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Medicines> medicines;

    @ManyToOne
    @JoinColumn(name = "doctor_patient_id")
    private Doctor_Patient doctorPatient;
}
