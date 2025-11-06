package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import spring_Tasks_Project.dto.Doctor_DepartmentDto;
import spring_Tasks_Project.model.Doctor_Department;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorDepartmentMapper {

    Doctor_Department toEntity(Doctor_DepartmentDto doctorDepartmentDto);

    Doctor_DepartmentDto toDto(Doctor_Department doctorDepartment);

    List<Doctor_DepartmentDto> toDtoList(List<Doctor_Department> doctorDepartments);
}
