package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.PatientDto;
import spring_Tasks_Project.service.PatientService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PatientController {

    private PatientService patientService;

    public  PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }

//__________________________________________________________

    @PostMapping("/addPatient")
    public ResponseEntity<PatientDto> addPatient(@RequestBody @Valid PatientDto patientDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/addPatient")).body(patientService.savePatient(patientDto));
    }

                            //______________________________

    @GetMapping("/getAllPatient")
    public ResponseEntity<List<PatientDto>> getAllPatients()
    {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

                            //______________________________

    @GetMapping("/getPatientById/{id}")
    public ResponseEntity<PatientDto>  getPatientById(@PathVariable Long id)
    {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

                                     //______________________________

    @PutMapping("/updatePatient")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody @Valid PatientDto patientDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/updatePatient")).body(patientService.updatePatient(patientDto));
    }

                            //______________________________

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Void>  deletePatientById(@PathVariable Long id)
    {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }

//________________________________________________________________

}
