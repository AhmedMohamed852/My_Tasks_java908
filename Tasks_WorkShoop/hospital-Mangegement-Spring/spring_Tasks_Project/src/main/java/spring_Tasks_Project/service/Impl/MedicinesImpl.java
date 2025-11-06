package spring_Tasks_Project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.MedicinesDto;
import spring_Tasks_Project.mapper.MedicinesMapper;
import spring_Tasks_Project.model.Medicines;
import spring_Tasks_Project.reposatory.MedicinesRepo;
import spring_Tasks_Project.service.MedicinesService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MedicinesImpl implements MedicinesService {


    private final MedicinesRepo medicinesRepo;
    private final MedicinesMapper medicinesMapper;

    @Autowired
    public MedicinesImpl (MedicinesRepo medicinesRepo , MedicinesMapper medicinesMapper)
    {
        this.medicinesRepo = medicinesRepo;
        this.medicinesMapper = medicinesMapper;
    }

//_____________________________________________________________________

    @Override
    public MedicinesDto saveMedicines(MedicinesDto medicinesDto)
    {
        if(!Objects.isNull(medicinesDto.getId()))
        {
            throw new RuntimeException("Id Must Be Null");
        }

        return medicinesMapper.toDto(medicinesRepo.save(medicinesMapper.toEntity(medicinesDto)));
    }

//_____________________________________________________________________


    @Override
    public MedicinesDto findMedicinesById(Long id)
    {
        Optional<Medicines> medicines = medicinesRepo.findById(id);

        if(!medicines.isPresent())
        {
            throw new RuntimeException("Medicines Not Found");
        }

        return medicinesMapper.toDto(medicines.get());
    }

//_____________________________________________________________________


    @Override
    public void deleteMedicinesById(Long id)
    {
        medicinesRepo.deleteById(id);
    }

//_____________________________________________________________________


    @Override
    public MedicinesDto updateMedicines(MedicinesDto medicinesDto) {
        if(Objects.isNull(medicinesDto.getId()))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }

        Optional<Medicines> medicines = medicinesRepo.findById(medicinesDto.getId());

        if(!medicines.isPresent())
        {
            throw new RuntimeException("Medicines Not Found");
        }

        return medicinesMapper.toDto(medicinesRepo.save(medicinesMapper.toEntity(medicinesDto)));
    }

//_____________________________________________________________________


    @Override
    public List<MedicinesDto> findAllMedicines()
    {
        return medicinesMapper.toDtoList(medicinesRepo.findAll());
    }
}
