package spring_Tasks_Project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.PrescriptionsDto;
import spring_Tasks_Project.mapper.PrescriptionsMapper;
import spring_Tasks_Project.model.Prescriptions;
import spring_Tasks_Project.reposatory.PrescriptionsRepo;
import spring_Tasks_Project.service.PrescriptionsService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PrescriptionsImpl implements PrescriptionsService {

    private final PrescriptionsRepo prescriptionsRepo;

    private final PrescriptionsMapper prescriptionsMapper;



    @Autowired
    public PrescriptionsImpl(PrescriptionsRepo prescriptionsRepo , PrescriptionsMapper prescriptionsMapper)
    {
        this.prescriptionsRepo = prescriptionsRepo;
        this.prescriptionsMapper = prescriptionsMapper;
    }

    //_____________________________________________________________________


    @Override
    public PrescriptionsDto savePrescriptions(PrescriptionsDto prescriptionsDto)
    {
        if (Objects.nonNull(prescriptionsDto.getId()))
        {
            throw new RuntimeException("Id Must Be Null");
        }

        return prescriptionsMapper.toDto(prescriptionsRepo.save(prescriptionsMapper.toEntity(prescriptionsDto)));
    }


    //_____________________________________________________________________

    @Override
    public PrescriptionsDto findPrescriptionsById(Long id)
    {

        Optional<Prescriptions> prescriptions = prescriptionsRepo.findById(id);

        if(!prescriptions.isPresent())
        {
            throw new RuntimeException("Prescriptions Not Found");
        }

        return prescriptionsMapper.toDto(prescriptions.get());
    }

    //_____________________________________________________________________


    @Override
    public void deletePrescriptionsById(Long id)
    {
        prescriptionsRepo.deleteById(id);
    }


    //_____________________________________________________________________


    @Override
    public PrescriptionsDto updatePrescriptions(PrescriptionsDto prescriptionsDto)
    {
        if(Objects.isNull(prescriptionsDto.getId()))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }

        Optional<Prescriptions> prescriptions = prescriptionsRepo.findById(prescriptionsDto.getId());

        if(!prescriptions.isPresent())
        {
            throw new RuntimeException("Prescriptions Not Found");
        }

        return prescriptionsMapper.toDto(prescriptionsRepo.save(prescriptionsMapper.toEntity(prescriptionsDto)));
    }


    //_____________________________________________________________________

    @Override
    public List<PrescriptionsDto> findAllPrescriptions()
    {
        return prescriptionsMapper.toDtoList(prescriptionsRepo.findAll());
    }

//_____________________________________________________________________



}
