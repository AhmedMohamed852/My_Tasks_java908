package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import spring_Tasks_Project.dto.MedicinesDto;
import spring_Tasks_Project.model.Medicines;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicinesMapper {

   Medicines toEntity(MedicinesDto medicinesDto);

   MedicinesDto toDto(Medicines medicines);

   List<MedicinesDto> toDtoList(List<Medicines> medicines);
}
