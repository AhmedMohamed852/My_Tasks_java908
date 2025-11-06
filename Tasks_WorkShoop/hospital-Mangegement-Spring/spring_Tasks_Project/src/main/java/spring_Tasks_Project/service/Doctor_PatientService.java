package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.Doctor_PatientDto;

public interface Doctor_PatientService {

    Doctor_PatientDto saveDoctor_Patient(Long doctorId, Long patientId);

    void deleteDoctor_Patient(Long id);

    Doctor_PatientDto updateDoctor_Patient(Long id , Doctor_PatientDto doctor_PatientDto);

}
