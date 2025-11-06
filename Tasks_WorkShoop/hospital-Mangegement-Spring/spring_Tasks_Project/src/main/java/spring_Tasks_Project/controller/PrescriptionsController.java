package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.PrescriptionsDto;
import spring_Tasks_Project.service.PrescriptionsService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PrescriptionsController {

    private final PrescriptionsService prescriptionsService;

    @Autowired
    public PrescriptionsController(PrescriptionsService prescriptionsService)
    {
        this.prescriptionsService = prescriptionsService;
    }

//_____________________________________________________________________

    @PostMapping("/addPrescriptions")
    public ResponseEntity<PrescriptionsDto> addPrescriptions(@RequestBody @Valid PrescriptionsDto prescriptionsDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/addPrescriptions")).body(prescriptionsService.savePrescriptions(prescriptionsDto));
    }

    //_____________________________________________________________________


    @PutMapping("/updatePrescriptions")
    public ResponseEntity<PrescriptionsDto> updatePrescriptions(@RequestBody @Valid PrescriptionsDto prescriptionsDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/updatePrescriptions")).body(prescriptionsService.updatePrescriptions(prescriptionsDto));
    }

    //_____________________________________________________________________


    @GetMapping("/findPrescriptionById/{id}")
    public ResponseEntity<PrescriptionsDto> findPrescriptionById(@PathVariable Long id)
    {
        return ResponseEntity.ok(prescriptionsService.findPrescriptionsById(id));
    }

    //_____________________________________________________________________


    @DeleteMapping("/deletePrescriptions/{id}")
    public ResponseEntity<Void> deletePrescriptionById (@PathVariable Long id)
    {
        prescriptionsService.deletePrescriptionsById(id);
        return ResponseEntity.noContent().build();
    }

    //_____________________________________________________________________


    @GetMapping("/findAllPrescriptions")
    public ResponseEntity<List<PrescriptionsDto>> findAllPrescriptions() throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/findAllPrescriptions")).body(prescriptionsService.findAllPrescriptions());
    }

    //_____________________________________________________________________


}
