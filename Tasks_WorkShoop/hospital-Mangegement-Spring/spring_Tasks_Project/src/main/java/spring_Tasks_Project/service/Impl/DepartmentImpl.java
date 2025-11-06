package spring_Tasks_Project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.DepartmentDto;
import spring_Tasks_Project.mapper.DepartmentMapper;
import spring_Tasks_Project.model.Department;
import spring_Tasks_Project.reposatory.DepartmentRepo;
import spring_Tasks_Project.service.DepartmentService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentImpl implements DepartmentService {

   private final DepartmentMapper departmentMapper;

  private final DepartmentRepo departmentRepo;

  @Autowired
  public DepartmentImpl(DepartmentRepo departmentRepo , DepartmentMapper departmentMapper)
  {
      this.departmentRepo = departmentRepo;
      this.departmentMapper = departmentMapper;
  }

//_____________________________________________________________________




    @Override
    public DepartmentDto save(DepartmentDto departmentDto)
    {

        if(Objects.nonNull(departmentDto.getId()))
        {
            throw new RuntimeException("Id Must Be Null");
        }

        return departmentMapper.toDto(departmentRepo.save(departmentMapper.toEntity(departmentDto)));
    }

    @Override
    public List<DepartmentDto> findAll()
    {
        return departmentMapper.toDtoList(departmentRepo.findAll());
    }

    @Override
    public DepartmentDto findById(Long id)
    {
        Optional<Department> department = departmentRepo.findById(id);

        if(!department.isPresent())
        {
            throw new RuntimeException("Department Not Found");
        }

        return departmentMapper.toDto(department.get());
    }

    @Override
    public DepartmentDto update(DepartmentDto departmentDto)
    {
        if(Objects.isNull(departmentDto.getId()))
        {
            throw new RuntimeException("Id Must Be Not Null");
        }
        Optional<Department> department = departmentRepo.findById(departmentDto.getId());

        if(!department.isPresent())
        {
            throw new RuntimeException("Department Not Found");
        }

        return departmentMapper.toDto(departmentRepo.save(departmentMapper.toEntity(departmentDto)));
    }

    @Override
    public void deleteById(Long id)
    {
        departmentRepo.deleteById(id);
    }
}
