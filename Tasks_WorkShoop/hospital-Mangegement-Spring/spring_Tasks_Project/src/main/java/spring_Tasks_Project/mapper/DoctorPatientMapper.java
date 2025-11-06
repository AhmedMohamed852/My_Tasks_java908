package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring_Tasks_Project.dto.Doctor_PatientDto;
import spring_Tasks_Project.model.Doctor_Patient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorPatientMapper {

  Doctor_Patient toEntity(Doctor_PatientDto doctorPatientDto);
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient", ignore = true)
 Doctor_PatientDto toDto(Doctor_Patient doctorPatient);

   List<Doctor_PatientDto> toDtoList(List<Doctor_Patient> doctorPatientList);
}
