package spring_Tasks_Project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.PatientDto;
import spring_Tasks_Project.mapper.PatientMapper;
import spring_Tasks_Project.model.Patient;
import spring_Tasks_Project.reposatory.PatientRepo;
import spring_Tasks_Project.service.PatientService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientImpl implements PatientService {


    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    @Autowired
    PatientImpl (PatientRepo patientRepo , PatientMapper patientMapper)
    {
       this.patientRepo = patientRepo;
       this.patientMapper = patientMapper;
    }

//_____________________________________________________________________





    @Override
    public PatientDto savePatient(PatientDto patientDto)
    {
        if(Objects.nonNull(patientDto.getId()))
        {
            throw new RuntimeException("Id Must Be Null");
        }

        return patientMapper.toDto(patientRepo.save(patientMapper.toEntity(patientDto)));
    }
                    //_________________________

    @Override
    public PatientDto getPatientById(Long id)
    {
        if(Objects.isNull(id))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }

        return patientMapper.toDto(patientRepo.findById(id).get());
    }

                        //_________________________

    @Override
    public List<PatientDto> getAllPatients()
    {
        return patientMapper.toDtoList(patientRepo.findAll());
    }

                            //_________________________

    @Override
    public PatientDto updatePatient(PatientDto patientDto)
    {
        if(Objects.isNull(patientDto.getId()))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }

        Optional<Patient> patient = patientRepo.findById(patientDto.getId());

        if(!patient.isPresent())
        {
            throw new RuntimeException("Patient Not Found");
        }

        return patientMapper.toDto(patientRepo.save(patientMapper.toEntity(patientDto)));
    }

                        //_________________________

    @Override
    public void deletePatientById(Long id)
    {
        patientRepo.deleteById(id);
    }
}
