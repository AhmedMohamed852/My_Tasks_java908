package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_Tasks_Project.model.Department;
import spring_Tasks_Project.model.Doctor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doctor_DepartmentDto {

    private Long id;

//____________ Relations ____________________________

    private DoctorDto doctor;

    private DepartmentDto department;


}
