package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto  departmentDto);

    List<DepartmentDto> findAll();

    DepartmentDto findById(Long id);

    DepartmentDto update(DepartmentDto  departmentDto);
    void deleteById(Long id);
}
