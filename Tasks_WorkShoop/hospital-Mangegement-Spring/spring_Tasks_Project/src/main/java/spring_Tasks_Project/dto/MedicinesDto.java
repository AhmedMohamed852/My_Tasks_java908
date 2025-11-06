package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class MedicinesDto {
    @Id
    private Long id;

    @NotBlank
    private String medicine_name;

    private double medicine_price;

    private int medicine_quantity;

//______________________________ Relations ________________________________

    private List<PrescriptionsDto> prescriptions;

}
