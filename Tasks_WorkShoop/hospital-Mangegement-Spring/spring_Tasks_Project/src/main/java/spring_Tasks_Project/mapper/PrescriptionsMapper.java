package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import spring_Tasks_Project.dto.PatientDto;
import spring_Tasks_Project.dto.PrescriptionsDto;
import spring_Tasks_Project.model.Patient;
import spring_Tasks_Project.model.Prescriptions;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionsMapper {

    Prescriptions toEntity(PrescriptionsDto prescriptionsDto);

   PrescriptionsDto toDto(Prescriptions prescriptions);

   List<PrescriptionsDto> toDtoList(List<Prescriptions> prescriptionsList);

}
