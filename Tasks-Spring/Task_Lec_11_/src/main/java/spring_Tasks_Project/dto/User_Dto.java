package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_Tasks_Project.model.Post;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User_Dto {

    private Long id;

    @NotBlank
    @Size(min = 8 , message = "Name must be at least 8 characters long")
    private String name;

    @Min(value = 18 , message = "Age must be at least 18 years old")
    @Max(value = 50 , message = "Age must be at most 50 years old")
    private int age;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%&*?])[A-Za-z\\d@$!%&*?]{8,}$")
    private String password;

//___________________________________________________
    @JsonIgnore
    private List<Post> posts;
}
