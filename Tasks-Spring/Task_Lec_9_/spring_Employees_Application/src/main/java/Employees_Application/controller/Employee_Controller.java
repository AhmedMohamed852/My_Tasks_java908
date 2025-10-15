package Employees_Application.controller;


import Employees_Application.dto.Employee_Dto;
import Employees_Application.service.Employee_Service;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class Employee_Controller {

    private Employee_Service employeeService;

    public Employee_Controller(Employee_Service employeeService) {
        this.employeeService = employeeService;
    }


//_______________________________________________________________________

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee_Dto>  saveEmployee(@RequestBody @Valid Employee_Dto employeeDto) throws URISyntaxException
    {
        return  ResponseEntity.created(new URI("/saveEmployee")).body(employeeService.saveEmployee(employeeDto));
    }

//_______________________________________________________________________


    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee_Dto> getEmployeeById(@PathVariable Long id)
    {

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

//_______________________________________________________________________


    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id)
    {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

//_______________________________________________________________________


    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee_Dto> updateEmployee(@RequestBody @Valid Employee_Dto employeeDto)
    {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }


//_______________________________________________________________________


    @GetMapping("/getAllEmployees")
    public ResponseEntity<Iterable<Employee_Dto>> getAllEmployees()
    {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

//_______________________________________________________________________



    @GetMapping("/getEmployeeByListOfIds")
    public ResponseEntity<List<Employee_Dto>> getEmployeeByListOfID(@RequestParam List<Long> ids)
    {
        return ResponseEntity.ok(employeeService.getEmployeeByListOfID(ids));
    }


//_______________________________________________________________________


    @GetMapping("/getEmployeeByListOfNames")
    public ResponseEntity<List<Employee_Dto>> getEmployeeByListOfName(@RequestParam @Valid List<String> names)
    {
        return ResponseEntity.ok(employeeService.getEmployeeByListOfName(names));
    }


//_______________________________________________________________________

}
