package spring_Tasks_Project.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_Tasks_Project.model.Users;

import java.util.Optional;

@Repository
public interface User_Repo extends JpaRepository<Users,Long> {
   Optional<Users> findByname(String name);
   Optional<Users> findByid(Long id);
}
