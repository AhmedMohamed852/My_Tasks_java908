package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring_Tasks_Project.dto.PatientDto;
import spring_Tasks_Project.model.Patient;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PatientMapper {


    Patient toEntity(PatientDto patientDto);
    PatientDto toDto(Patient patient);

    List<PatientDto> toDtoList(List<Patient> patients);

}
