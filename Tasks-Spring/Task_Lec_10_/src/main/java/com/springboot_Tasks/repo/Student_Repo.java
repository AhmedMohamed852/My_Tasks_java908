package com.springboot_Tasks.repo;

import com.springboot_Tasks.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Student_Repo extends JpaRepository<Student,Long> {

   Optional<Student> findByusername(String studentName);
}
