package spring_Tasks_Project.service;

import org.springframework.web.bind.annotation.RequestParam;
import spring_Tasks_Project.dto.PatientDto;

import java.util.List;

public interface PatientService {



    PatientDto savePatient(PatientDto patientDto);

    PatientDto getPatientById( Long id);

    List<PatientDto> getAllPatients();

    PatientDto updatePatient(PatientDto patientDto);

    void deletePatientById(Long id);
}
