package Employees_Application.service.impl;

import Employees_Application.dto.Employee_Dto;
import Employees_Application.maper.Employee_Mapper;
import Employees_Application.repo.Employee_Repo;
import Employees_Application.service.Employee_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Employees_Application.model.Employee_E;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Employee_impl implements Employee_Service {


    private Employee_Repo employeeRepo;
    private Employee_Mapper employeeMapper;

    @Autowired
    public Employee_impl(Employee_Repo employeeRepo, Employee_Mapper employeeMapper)
    {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }





//_______________________________________________________________
    @Override
    public Employee_Dto saveEmployee(Employee_Dto employeeDto) {
        Optional<Employee_E> employee = employeeRepo.findByName(employeeDto.getName());

        if(employee.isPresent())
        {
            throw new RuntimeException("Employee_impl with this id already exists");
        }

        if(Objects.nonNull(employeeDto.getId()))
        {
            throw new RuntimeException("id must be null");
        }

        return employeeMapper.toDto(employeeRepo.save(employeeMapper.toEntity(employeeDto)));
    }

    //_______________________________________________________________



    @Override
    public Employee_Dto getEmployeeById(Long id) {
        Optional<Employee_E> employee = employeeRepo.findById(id);

        if(!employee.isPresent())
        {
            throw new RuntimeException("Employee_impl with this id does not exist");
        }
        Employee_Dto employeeDto = employeeMapper.toDto(employee.get());
        return employeeDto;
    }


    //_______________________________________________________________


    @Override
    public void deleteEmployeeById(Long id) {

        Optional<Employee_E> employee = employeeRepo.findById(id);


        if(!employee.isPresent())
        {
            throw new RuntimeException("Employee_impl with this id does not exist");
        }
        employeeRepo.deleteById(id);

    }


    //_______________________________________________________________


    @Override
    public Employee_Dto updateEmployee(Employee_Dto employeeDto) {

        Optional<Employee_E> employee = employeeRepo.findById(employeeDto.getId());

        if(!employee.isPresent())
        {
            throw new RuntimeException("Employee_impl with this id does not exist");
        }

        if(Objects.isNull(employeeDto.getId()))
        {
            throw new RuntimeException("id must not be null");
        }

        employeeRepo.save(employeeMapper.toEntity(employeeDto));
        return  employeeDto;
    }



    //_______________________________________________________________


    @Override
    public List<Employee_Dto> getAllEmployees() {
        return employeeMapper.toDtoList(employeeRepo.findAll());
    }



    //_______________________________________________________________


    @Override
    public List<Employee_Dto> getEmployeeByListOfID(List<Long> ids) {

      return employeeMapper.toDtoList(employeeRepo.findAllById(ids));

    }



    //_______________________________________________________________


    @Override
    public List<Employee_Dto> getEmployeeByListOfName(List<String> names) {

        return employeeMapper.toDtoList(employeeRepo.findByNameIn(names));

    }



    //_______________________________________________________________

}
