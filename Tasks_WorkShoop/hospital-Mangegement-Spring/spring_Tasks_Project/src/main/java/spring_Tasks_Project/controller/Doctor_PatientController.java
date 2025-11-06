package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.Doctor_PatientDto;
import spring_Tasks_Project.service.Doctor_PatientService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class Doctor_PatientController {

    private final Doctor_PatientService doctor_PatientService;

    // TODO Problem hire <<-----------------------------
    // TODO Problem hire <<-----------------------------
    public Doctor_PatientController(Doctor_PatientService doctor_PatientService)
    {
        this.doctor_PatientService = doctor_PatientService;
    }


    //_________________________________________________________________________

    @PostMapping("/addDoctorPatient/{doctorId}/{patientId}")
    public ResponseEntity<Doctor_PatientDto> addDoctorPatient (@PathVariable Long doctorId ,@PathVariable Long patientId) throws URISyntaxException
    {
      return   ResponseEntity.created(new URI("/addDoctorPatient")).body(doctor_PatientService.saveDoctor_Patient(doctorId,patientId));
    }


    //_________________________________________________________________________


    @PutMapping("/updateDoctorPatient/{id}")
    public ResponseEntity<Doctor_PatientDto> updateDoctorPatient (@PathVariable Long id , @RequestBody @Valid Doctor_PatientDto doctor_PatientDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/updateDoctorPatient")).body(doctor_PatientService.updateDoctor_Patient(id ,doctor_PatientDto));
    }

    //_________________________________________________________________________


    @DeleteMapping("/deleteDoctorPatient/{id}")
    public ResponseEntity<Void> deleteDoctorPatient(@PathVariable Long id)
    {
        doctor_PatientService.deleteDoctor_Patient(id);
        ResponseEntity.noContent().build();
        return null;
    }


    //_________________________________________________________________________


}
