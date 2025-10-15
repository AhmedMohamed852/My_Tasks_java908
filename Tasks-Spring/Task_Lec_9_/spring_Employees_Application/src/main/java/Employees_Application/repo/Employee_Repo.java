package Employees_Application.repo;

import Employees_Application.model.Employee_E;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Employee_Repo extends JpaRepository<Employee_E, Long> {

   Optional<Employee_E> findByName(String name);

    List<Employee_E> findByNameIn(List<String> names);

}
