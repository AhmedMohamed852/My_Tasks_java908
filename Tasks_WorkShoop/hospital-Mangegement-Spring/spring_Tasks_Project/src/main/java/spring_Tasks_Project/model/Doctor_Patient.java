package spring_Tasks_Project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Doctor_Patient_S" ,
    uniqueConstraints = @UniqueConstraint(columnNames = {"doctor_id" , "patient_id"}))

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctor_Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

//____________ Relations ____________________________

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id" , nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id" , nullable = false)
    private Patient patient;

    @OneToMany(mappedBy = "doctorPatient", cascade = CascadeType.ALL)
    private List<Prescriptions> prescriptions ;


    public Doctor_Patient(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        this.status = "Active";
    }
}
