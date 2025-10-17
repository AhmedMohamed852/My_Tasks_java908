package Employees_Application.maper;


import Employees_Application.dto.Employee_Dto;
import Employees_Application.model.Employee_E;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Employee_Mapper {

   Employee_E toEntity (Employee_Dto employeeDto);

   Employee_Dto toDto(Employee_E employee);

  List<Employee_Dto> toDtoList(java.util.List<Employee_E> employeeList);


}
