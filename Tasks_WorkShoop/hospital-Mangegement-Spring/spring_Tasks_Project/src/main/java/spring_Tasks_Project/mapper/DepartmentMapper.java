package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import spring_Tasks_Project.dto.DepartmentDto;
import spring_Tasks_Project.dto.PatientDto;
import spring_Tasks_Project.model.Department;
import spring_Tasks_Project.model.Patient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

   Department toEntity(DepartmentDto departmentDto);

   DepartmentDto toDto(Department department);

   List<DepartmentDto> toDtoList(List<Department> departments);



}
