package spring_Tasks_Project.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.DoctorDto;
import spring_Tasks_Project.dto.Doctor_PatientDto;
import spring_Tasks_Project.mapper.DoctorPatientMapper;
import spring_Tasks_Project.model.Doctor;
import spring_Tasks_Project.model.Doctor_Patient;
import spring_Tasks_Project.model.Patient;
import spring_Tasks_Project.reposatory.DoctorRepo;
import spring_Tasks_Project.reposatory.Doctor_PatientRepo;
import spring_Tasks_Project.reposatory.PatientRepo;
import spring_Tasks_Project.service.Doctor_PatientService;

import java.util.Objects;
import java.util.Optional;

@Service
public class Doctor_PatientImpl implements Doctor_PatientService {

    private final Doctor_PatientRepo doctor_PatientRepo;

    private final DoctorPatientMapper doctorPatientMapper;

    private final DoctorRepo doctorRepo;

    private final PatientRepo patientRepo;

    @Autowired
    public Doctor_PatientImpl(Doctor_PatientRepo doctor_PatientRepo , DoctorPatientMapper doctorPatientMapper ,
                              DoctorRepo doctorRepo , PatientRepo patientRepo)
    {
        this.doctor_PatientRepo = doctor_PatientRepo;
        this.doctorPatientMapper = doctorPatientMapper;
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
    }

//_________________________________________________________________________

    @Override
    public Doctor_PatientDto saveDoctor_Patient(Long doctorId, Long patientId )
    {
       Optional<Doctor> doctor = doctorRepo.findById(doctorId);
       Optional<Patient> patient = patientRepo.findById(patientId);

       if(!doctor.isPresent() && !patient.isPresent())
       {
           throw new RuntimeException("Doctor Or Patient Not Found");
       }

      return doctorPatientMapper.toDto(doctor_PatientRepo.save(new Doctor_Patient(doctor.get(),patient.get())));
    }



    //_________________________________________________________________________


    @Override
    public void deleteDoctor_Patient(Long id)
    {
        doctor_PatientRepo.deleteById(id);
    }


    //_________________________________________________________________________


    @Override
    public Doctor_PatientDto updateDoctor_Patient(Long id ,Doctor_PatientDto doctor_PatientDto)
    {
        Doctor_Patient existingEntity = doctor_PatientRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor_Patient not found"));

        if(doctor_PatientDto.getStatus() != null)
        {
            existingEntity.setStatus(doctor_PatientDto.getStatus());
        }

        doctor_PatientDto = doctorPatientMapper.toDto(doctor_PatientRepo.save(existingEntity));
        return doctor_PatientDto;
    }




    //_________________________________________________________________________

}
