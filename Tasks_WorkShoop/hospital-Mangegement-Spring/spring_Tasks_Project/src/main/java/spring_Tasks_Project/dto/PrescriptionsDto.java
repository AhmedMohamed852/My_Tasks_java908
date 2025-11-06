package spring_Tasks_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
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
public class PrescriptionsDto {

    private Long id;

    private int quantity;

//______________________________ Relations ________________________________

    private List<MedicinesDto> medicines;

    private Doctor_PatientDto doctorPatient;
}
