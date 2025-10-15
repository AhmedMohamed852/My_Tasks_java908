package Employees_Application.dto;

import Employees_Application.model.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee_Dto {

//______________attributes_________________________________________
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 15 , message = "Age must be greater than 15")
    @Max(value = 40 , message = "Age must be less than 40")
    private int age;

    @NotNull
    @Min(value = 5000 , message = "Salary must be greater than 5000")
    @Max(value = 100000 , message = "Salary must be less than 100000")
    private double salary;

    //______________relations_________________________________________

    private java.util.List<Email> emails;


}
