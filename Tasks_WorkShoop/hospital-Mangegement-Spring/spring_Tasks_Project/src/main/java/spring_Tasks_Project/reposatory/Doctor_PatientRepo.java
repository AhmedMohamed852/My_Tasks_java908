package spring_Tasks_Project.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_Tasks_Project.model.Doctor_Patient;

@Repository
public interface Doctor_PatientRepo extends JpaRepository<Doctor_Patient, Long> {
}
