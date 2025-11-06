package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.DoctorDto;
import spring_Tasks_Project.model.Doctor;

import java.util.List;

public interface DoctorService {

    DoctorDto saveDoctor(DoctorDto doctorDto);

    DoctorDto findDoctorById(Long id);

    List<DoctorDto> findAllDoctors();

    DoctorDto updateDoctor(DoctorDto doctor);

    void deleteDoctorById(Long id);
}
