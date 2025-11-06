package spring_Tasks_Project.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_Tasks_Project.model.Patient;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    Optional<Patient> findPatientByfirstName(String first_name);
}
