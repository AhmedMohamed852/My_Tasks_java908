package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.DoctorDto;
import spring_Tasks_Project.service.DoctorService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DoctorController {

    private DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }

//_____________________________________________________________

    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<DoctorDto>> findAllDoctors()
    {
        return  ResponseEntity.ok(doctorService.findAllDoctors());
    }

                        //___________________________//

    @GetMapping("/getDoctorById/{id}")
    public ResponseEntity<DoctorDto> findDoctorById(@PathVariable Long id)
    {
        return  ResponseEntity.ok(doctorService.findDoctorById(id));
    }

                        //___________________________//

    @PostMapping("/saveDoctor")
    public ResponseEntity<DoctorDto> saveDoctor(@RequestBody @Valid DoctorDto doctorDto) throws URISyntaxException
    {
        return  ResponseEntity.created(new URI("/saveDoctor")).body(doctorService.saveDoctor(doctorDto));
    }

                             //___________________________//


    @PutMapping("/updateDoctor")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody @Valid DoctorDto doctorDto)  throws URISyntaxException
    {
        return  ResponseEntity.created(new URI("/updateDoctor")).body(doctorService.updateDoctor(doctorDto));
    }

                          //___________________________//

    @DeleteMapping("deleteDoctoreById/{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable Long id)
    {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }
}
