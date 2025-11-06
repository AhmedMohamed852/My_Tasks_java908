package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring_Tasks_Project.dto.DoctorDto;
import spring_Tasks_Project.model.Doctor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper
{

   Doctor toEntity(DoctorDto doctorDto);
   DoctorDto toDto(Doctor doctor);

   List<DoctorDto> toDtoList(List<Doctor> doctors);


}
