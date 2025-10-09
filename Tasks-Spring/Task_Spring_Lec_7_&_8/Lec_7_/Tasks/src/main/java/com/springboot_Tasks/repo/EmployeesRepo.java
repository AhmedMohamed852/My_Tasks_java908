package com.springboot_Tasks.repo;


import com.springboot_Tasks.model.Employees_Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees_Task, Integer> {

    Optional<Employees_Task> findByName(String NAME);

    @Query(value = "select * from Employees_Task where lower(name) like  lower(CONCAT(:name,'%'))" , nativeQuery = true)
    List<Employees_Task> findAllByNative(@Param("name") String name);


    @Query(value = "select e from Employees_Task e where lower(e.name) like  lower(CONCAT(:name,'%')) ")
    List<Employees_Task> findAllByNonNative(@Param("name") String name);


    List<Employees_Task> findByNameStartingWithIgnoreCase(String name);


}
