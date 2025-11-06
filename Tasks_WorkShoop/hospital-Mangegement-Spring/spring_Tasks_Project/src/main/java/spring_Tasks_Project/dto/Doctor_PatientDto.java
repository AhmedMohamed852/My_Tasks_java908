package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_Tasks_Project.model.Doctor;
import spring_Tasks_Project.model.Patient;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctor_PatientDto {

    private Long id;
    @NotBlank
    private String status;

//____________ Relations ____________________________

    private DoctorDto doctor;

    private PatientDto patient;

    private List<PrescriptionsDto> prescriptions ;

    public Doctor_PatientDto(DoctorDto doctorDto, PatientDto patientDto) {
        this.doctor = doctor;
        this.patient = patient;
        this.status = "Active";
    }
}
