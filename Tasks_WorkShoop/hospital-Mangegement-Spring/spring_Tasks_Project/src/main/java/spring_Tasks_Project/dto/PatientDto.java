package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_Tasks_Project.gender.Gender;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDto {

    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String last_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotBlank
    private String phone;
    private String address;

//____________ Relations ____________________________

    private List<Doctor_PatientDto> doctor_patient;
}
