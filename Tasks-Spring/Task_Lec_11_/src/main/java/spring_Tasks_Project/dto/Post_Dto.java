package spring_Tasks_Project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_Tasks_Project.model.Users;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post_Dto {

    private Long id;

    @NotBlank
    @Size(min = 8 , message = "Name must be at least 8 characters long")
    String text;

    String imagePath;

//____________________________________________________________
    Users users;
}
