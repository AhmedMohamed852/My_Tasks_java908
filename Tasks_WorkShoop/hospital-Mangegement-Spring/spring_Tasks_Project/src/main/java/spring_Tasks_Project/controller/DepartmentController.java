package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.DepartmentDto;
import spring_Tasks_Project.service.DepartmentService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

//____________________________________________________________

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> addDepartment (@RequestBody @Valid DepartmentDto departmentDto) throws Exception
    {
        return ResponseEntity.created(new URI("/addDepartment")).body(departmentService.save(departmentDto));
    }

                                     //__________________________________________

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<DepartmentDto> findDepartmentById(@PathVariable Long id)
    {
        return ResponseEntity.ok(departmentService.findById(id));
    }

                        //__________________________________________


    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<DepartmentDto>> findAllDepartments()
    {
        return ResponseEntity.ok(departmentService.findAll());
    }

                                         //__________________________________________


    @PutMapping("/updateDepartment")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody @Valid DepartmentDto departmentDto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/updateDepartment")).body(departmentService.update(departmentDto));
    }

                                     //__________________________________________


    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable Long id)
    {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

                        //__________________________________________


}
