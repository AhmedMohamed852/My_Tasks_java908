package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {

    private Long id;

    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    @NotBlank
    private String specialization;
    @NotBlank
    private String phone;
    private Double salary;
//____________ Relations ____________________________

    private List<Doctor_PatientDto> doctor_patient ;

    private List<Doctor_DepartmentDto> doctor_department ;








}
