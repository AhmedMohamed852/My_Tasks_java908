package com.springboot_Tasks.repo;

import com.springboot_Tasks.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Teacher_Repo extends JpaRepository<Teacher,Long> {

    Optional<Teacher> findByusername(String teacherName);
}
