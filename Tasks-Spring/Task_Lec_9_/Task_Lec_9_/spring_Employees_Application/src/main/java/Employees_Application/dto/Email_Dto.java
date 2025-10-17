package Employees_Application.dto;


import Employees_Application.model.Employee_E;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email_Dto {
    //______________attributes_________________________________________
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String content;


    //_______________relations__________________________________________

    private Employee_E employee;
}
