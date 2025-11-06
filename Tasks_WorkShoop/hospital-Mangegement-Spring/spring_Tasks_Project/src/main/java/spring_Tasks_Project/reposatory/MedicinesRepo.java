package spring_Tasks_Project.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_Tasks_Project.model.Medicines;

@Repository
public interface MedicinesRepo extends JpaRepository<Medicines,Long> {
}
