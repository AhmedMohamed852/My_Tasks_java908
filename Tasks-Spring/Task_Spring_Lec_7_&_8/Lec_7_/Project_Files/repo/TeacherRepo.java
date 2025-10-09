package com.springbootproject_1.repo;


import com.springbootproject_1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByUsername(String username);
    //@Query("select t from Teacher t where t.username=:username")
   // @Query(value = "select * from TEACHER where USERNAME =:username" , nativeQuery = true )
   //Optional<Teacher> getByUsername(@Param("username") String username);

    //___________________________________________


}
