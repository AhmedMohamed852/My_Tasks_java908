package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.MedicinesDto;
import spring_Tasks_Project.service.MedicinesService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class MedicinesController {

    private final MedicinesService medicinesService;

    @Autowired
    public MedicinesController(MedicinesService medicinesService)
    {
        this.medicinesService = medicinesService;
    }

//______________________________________________________________________

    @PostMapping("/addMedicines")
    public ResponseEntity<MedicinesDto> addMedicines(@RequestBody @Valid MedicinesDto medicinesDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/addMedicines")).body(medicinesService.saveMedicines(medicinesDto));
    }

    //_____________________________________________________________________


    @GetMapping("/getMedicinesById/{id}")
    public ResponseEntity<MedicinesDto> findMedicinesById(@PathVariable Long id)
    {
        return ResponseEntity.ok(medicinesService.findMedicinesById(id));
    }


    //_____________________________________________________________________


    @PutMapping("/updateMedicines")
    public ResponseEntity<MedicinesDto> updateMedicines(@RequestBody @Valid MedicinesDto medicinesDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/updateMedicines")).body(medicinesService.updateMedicines(medicinesDto));
    }

    //_____________________________________________________________________


    @GetMapping("/getAllMedicines")
    public ResponseEntity<List<MedicinesDto>> findAllMedicines()
    {
        return ResponseEntity.ok(medicinesService.findAllMedicines());
    }

    //_____________________________________________________________________


    @DeleteMapping("/deleteMedicines/{id}")
    public ResponseEntity<Void> deleteMedicine (@PathVariable Long id)
    {
        medicinesService.deleteMedicinesById(id);
        return ResponseEntity.noContent().build();
    }

    //_____________________________________________________________________


}
