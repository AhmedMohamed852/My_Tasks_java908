package Employees_Application.service;

import Employees_Application.dto.Employee_Dto;

import java.util.List;

public interface Employee_Service {

    Employee_Dto saveEmployee(Employee_Dto employeeDto);

    Employee_Dto getEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    Employee_Dto updateEmployee(Employee_Dto employeeDto);

    List<Employee_Dto> getAllEmployees();

    List<Employee_Dto> getEmployeeByListOfID(List<Long> ids);

    List<Employee_Dto> getEmployeeByListOfName(List<String> names);


}
