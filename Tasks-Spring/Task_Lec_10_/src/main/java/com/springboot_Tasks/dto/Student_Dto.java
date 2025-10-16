package com.springboot_Tasks.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot_Tasks.model.Teacher;
import jakarta.persistence.Entity;
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
public class Student_Dto {

    private Long id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;



    //_____________________________--
    private List<Teacher> teachers;



}
