package com.springboot_Tasks.service;

import com.springboot_Tasks.model.Employees_Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeesService {


    List<Employees_Task> getAllEmployees();

    List<Employees_Task> getEmployeesByListOfIds(List<Integer>  ids);

    Employees_Task saveEmployee(Employees_Task employees_task);

    List<Employees_Task> saveEmployeesByListOfId(List<Employees_Task> employees_tasks);

    Employees_Task updateEmployeeById(Employees_Task employees_task);

    List<Employees_Task> updateEmployeesByListOfIds(List<Employees_Task> employees_tasks);

    void deleteEmployeeById(int id);

    void deleteEmployeesByListOfIds(List<Integer> ids);

    List<Employees_Task> findAllEmployeesByNative(String name);

    List<Employees_Task> findAllEmployeesByNonNative(String name);

    List<Employees_Task> findByNameStartingWith(String name);


}
