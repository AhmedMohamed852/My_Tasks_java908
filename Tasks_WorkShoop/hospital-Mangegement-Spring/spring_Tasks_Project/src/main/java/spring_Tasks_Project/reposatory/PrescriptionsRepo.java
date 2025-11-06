package spring_Tasks_Project.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_Tasks_Project.model.Prescriptions;

@Repository
public interface PrescriptionsRepo extends JpaRepository<Prescriptions, Long> {
}
