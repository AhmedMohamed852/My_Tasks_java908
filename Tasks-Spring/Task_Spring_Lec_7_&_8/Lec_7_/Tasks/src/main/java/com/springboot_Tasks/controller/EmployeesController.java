package com.springboot_Tasks.controller;



import com.springboot_Tasks.model.Employees_Task;
import com.springboot_Tasks.service.impl.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeesController {


private EmployeesServiceImpl employeesServiceImpl;
    @Autowired
    public EmployeesController(EmployeesServiceImpl employeesServiceImpl) {
        this.employeesServiceImpl = employeesServiceImpl;
    }

//_________________________ api to get all employee _________________________________________
//___________________________________________________________________________________________
    @GetMapping("/employees")
    public List<Employees_Task> getAllEmployees ()
    {
      return employeesServiceImpl.getAllEmployees();
    }


//_________________________ api to get all employee by List of ids___________________________
//___________________________________________________________________________________________
    @GetMapping("/employeesByListOfIds")
    public List<Employees_Task> getAllEmployeesByListOfIds (@RequestParam List<Integer> ids)
    {
      return employeesServiceImpl.getEmployeesByListOfIds(ids);
    }



//_________________________ api to save employee data________________________________________
//___________________________________________________________________________________________
    @PostMapping("/saveEmployee")
    public Employees_Task saveEmployee(@RequestBody Employees_Task employees_task)
    {
        return employeesServiceImpl.saveEmployee(employees_task);
    }




//_________________________ api to save List of employee_____________________________________
//___________________________________________________________________________________________
    @PostMapping("/saveEmployeesByListOfId")
    public List<Employees_Task> saveEmployeesByListOfId(@RequestBody List<Employees_Task> employees_tasks)
    {
        return employeesServiceImpl.saveEmployeesByListOfId(employees_tasks);
    }



//_________________________ api to update employee __________________________________________
//___________________________________________________________________________________________
    @PutMapping("/updateEmployeeById")
    public Employees_Task updateEmployeeById(@RequestBody Employees_Task employees_task)
    {
        return employeesServiceImpl.updateEmployeeById(employees_task);
    }



//_________________________ api to update List of employee __________________________________________
//___________________________________________________________________________________________________

    @PutMapping("/updateEmployeesByListOfIds")
    public List<Employees_Task> updateEmployeesByListOfIds(@RequestBody List<Employees_Task> employees_tasks)
    {
        return employeesServiceImpl.updateEmployeesByListOfIds(employees_tasks);
    }




//_________________________ api to delete all employee ______________________________________________
//___________________________________________________________________________________________________

    @DeleteMapping("/deleteEmployeesByListOfIds")
    public void deleteEmployeesByListOfIds(@RequestParam List<Integer> ids)
    {
        employeesServiceImpl.deleteEmployeesByListOfIds(ids);
    }



//_________________________ api to delete all employee ______________________________________________
//___________________________________________________________________________________________________
    @DeleteMapping("/deleteEmployeeById")
    public void deleteEmployeeById(@RequestParam int id)
    {
        employeesServiceImpl.deleteEmployeeById(id);
    }



    //_________________________ api to search about employee by name ( Native query ) ___________________
//___________________________________________________________________________________________________
    @GetMapping("/employeesByNative")
    public List<Employees_Task> findAllEmployeesByNative(@RequestParam String name) {
        return employeesServiceImpl.findAllEmployeesByNative(name);
    }




//_________________________ api to search about employee by name ( None native query ) ___________________
//___________________________________________________________________________________________________

    @GetMapping("/employeesByNonNative")
    public List<Employees_Task> findAllEmployeesByNonNative(@RequestParam String name) {
        return employeesServiceImpl.findAllEmployeesByNonNative(name);
    }




//_________________________ api to search about employee by name ( FIndNameStartingWith ) ___________
//___________________________________________________________________________________________________
    @GetMapping("/employeesByNameStartingWith")
    public List<Employees_Task> findByNameStartingWith(@RequestParam String name) {
        return employeesServiceImpl.findByNameStartingWith(name);
    }













}
