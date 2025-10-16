package com.springboot_Tasks.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot_Tasks.model.Student;
import com.springboot_Tasks.model.Teacher;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Teacher_Dto {

    private Long id;
    @NotBlank
    private String username;

    @NotBlank
    private String password;

//_____________________________________________--

    private List<Student> students;



}
