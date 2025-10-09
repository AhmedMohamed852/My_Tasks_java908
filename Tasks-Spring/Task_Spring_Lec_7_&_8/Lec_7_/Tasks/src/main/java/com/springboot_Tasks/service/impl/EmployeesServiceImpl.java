package com.springboot_Tasks.service.impl;


import com.springboot_Tasks.model.Employees_Task;
import com.springboot_Tasks.repo.EmployeesRepo;
import com.springboot_Tasks.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    EmployeesRepo employeesRepo;

    @Autowired
    public EmployeesServiceImpl(EmployeesRepo employeesRepo)
    {
        this.employeesRepo = employeesRepo;
    }

//_________________________ api to get all employee ___________________________
//_____________________________________________________________________________

    @Override
    public List<Employees_Task> getAllEmployees()
    {

        return employeesRepo.findAll();
    }


//_________________________ api to get all employee by List of ids___________________________
//___________________________________________________________________________________________

    @Override
    public List<Employees_Task> getEmployeesByListOfIds(List<Integer> ids)
    {
        return employeesRepo.findAllById(ids);
    }


    //_________________________ api to save employee data___________________________
//___________________________________________________________________________________________
    @Override
    public Employees_Task saveEmployee(Employees_Task employees_task) {

        Optional<Employees_Task> employee = employeesRepo.findByName(employees_task.getName());

        if (employees_task.getId() != 0) {
            throw new RuntimeException("Employee id must be null");
        }

        if (Objects.isNull(employees_task.getName())) {
            throw new RuntimeException("Employee name must be not null");
        }

        if (employees_task.getAge() < 10) {
            throw new RuntimeException("Age must be greater than 10 years   ");
        }

        if (employee.isPresent() || employees_task.getName().isEmpty()) {
            throw new RuntimeException("Employee already exists or must be not Empty");
        }

        return employeesRepo.save(employees_task);

    }


//_________________________ api to save List of employee_____________________________________
//___________________________________________________________________________________________
    @Override
    public List<Employees_Task> saveEmployeesByListOfId(List<Employees_Task> employees_tasks)
    {

      for (Employees_Task employees : employees_tasks)
      {

          Optional<Employees_Task> employee = employeesRepo.findByName(employees.getName());

          if (employee.isPresent())
          {throw new RuntimeException("Employee already exists");}

          if (employees.getAge() < 10)
          {throw new RuntimeException("Age must be greater than 10 years   ");}

          if (employees.getName().isEmpty() || Objects.isNull(employees.getName()) )
          {throw new RuntimeException("Employee name is Empty or must be not null");}


          if (Objects.isNull(employees.getId()))
          {throw new RuntimeException("Employee id must be null");}

      }

      return employeesRepo.saveAll(employees_tasks);
    }



//_________________________ api to update employee __________________________________________
//___________________________________________________________________________________________
    @Override
    public Employees_Task updateEmployeeById(Employees_Task employees_task)
    {

        if (employees_task.getId() == 0)
        {throw new RuntimeException("Employee id must be not null");}


        if(employeesRepo.findById(employees_task.getId()).isEmpty())
        {throw new RuntimeException("Employee does not exist");}


        if (Objects.isNull(employees_task.getName()) ||  employees_task.getName().isEmpty())
        {throw new RuntimeException("Employee name must be not null or must be not Empty");}


        if (employees_task.getAge() < 10)
        {throw new RuntimeException("Age must be greater than 10 years   ");}


        return employeesRepo.save(employees_task);

    }




//_________________________ api to update List of employee __________________________________________
//___________________________________________________________________________________________________
    @Override
    public List<Employees_Task> updateEmployeesByListOfIds(List<Employees_Task> employees_tasks) {

        for (Employees_Task employees : employees_tasks)
        {

            if (employees.getId() == 0)
            {throw new RuntimeException("Employee id must be not null");}

            if(employeesRepo.findById(employees.getId()).isEmpty())
            {throw new RuntimeException("Employee does not exist");}


            if (employees.getName().isEmpty() || Objects.isNull(employees.getName()))
            {throw new RuntimeException("Employee name must be not null or must be not Empty");}

            if (employees.getAge() < 10)
            {throw new RuntimeException("Age must be greater than 10 years");}

        }

      return employeesRepo.saveAll(employees_tasks);

    }


//_________________________ api to delete employee by id ______________________________________________
//___________________________________________________________________________________________________

    @Override
    public void deleteEmployeeById(int id) {
        employeesRepo.deleteById(id);
    }



//_________________________ api to delete all employee ______________________________________________
//___________________________________________________________________________________________________
    @Override
    public void deleteEmployeesByListOfIds(List<Integer> ids) {

        employeesRepo.deleteAllById(ids);
    }




//_________________________ api to search about employee by name ( Native query ) ___________________
//___________________________________________________________________________________________________

    @Override
    public List<Employees_Task> findAllEmployeesByNative(String name) {
        return employeesRepo.findAllByNative(name);
    }




//_________________________ api to search about employee by name ( None native query ) ___________________
//___________________________________________________________________________________________________

    @Override
    public List<Employees_Task> findAllEmployeesByNonNative(String name) {
        return employeesRepo.findAllByNonNative(name);
    }




//_________________________ api to search about employee by name ( FIndNameStartingWith ) ___________
//___________________________________________________________________________________________________

    @Override
    public List<Employees_Task> findByNameStartingWith(String name) {
        return employeesRepo.findByNameStartingWithIgnoreCase(name);
    }

















}