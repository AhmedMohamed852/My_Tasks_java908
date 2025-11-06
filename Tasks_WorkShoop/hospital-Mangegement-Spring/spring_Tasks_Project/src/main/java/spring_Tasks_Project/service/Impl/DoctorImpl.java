package spring_Tasks_Project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.DoctorDto;
import spring_Tasks_Project.mapper.DoctorMapper;
import spring_Tasks_Project.model.Doctor;
import spring_Tasks_Project.reposatory.DoctorRepo;
import spring_Tasks_Project.service.DoctorService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoctorImpl implements DoctorService {

   private final DoctorRepo doctorRepo;
   private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorImpl(DoctorRepo doctorRepo , DoctorMapper doctorMapper)
    {
        this.doctorRepo = doctorRepo;
        this.doctorMapper = doctorMapper;
    }
//___________________________________________________________


    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto)
    {

        if(Objects.nonNull(doctorDto.getId()))
        {
            throw new RuntimeException("Id Must Be Null");
        }

        return doctorMapper.toDto(doctorRepo.save(doctorMapper.toEntity(doctorDto)));
    }

                      //___________________________//

    @Override
    public DoctorDto findDoctorById(Long id)
    {
        Optional<Doctor> doctor = doctorRepo.findById(id);

        if(doctor.isEmpty())
        {
            throw new RuntimeException("Doctor Not Found");
        }

        return doctorMapper.toDto(doctor.get());
    }

                      //___________________________//

    @Override
    public List<DoctorDto> findAllDoctors()
    {
        return doctorMapper.toDtoList(doctorRepo.findAll());
    }
                        //___________________________//

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto)
    {
        if(Objects.isNull(doctorDto.getId()))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }

        Optional<Doctor> doctor = doctorRepo.findById(doctorDto.getId());

        if(doctor.isEmpty())
        {
            throw new RuntimeException("Doctor Not Found");
        }

        return doctorMapper.toDto(doctorRepo.save(doctorMapper.toEntity(doctorDto)));
    }

                                //___________________________//


    @Override
    public void deleteDoctorById(Long id)
    {
        if (Objects.isNull(id))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }

        doctorRepo.deleteById(id);

    }


//_________________________________________________________________

}
