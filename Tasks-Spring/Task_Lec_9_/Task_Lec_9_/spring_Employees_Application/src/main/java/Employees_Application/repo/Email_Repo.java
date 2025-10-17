package Employees_Application.repo;

import Employees_Application.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Email_Repo extends JpaRepository<Email, Long> {

  Optional <Email> findByName(String name);

    Optional<List<Email>> findAllByNameIn(List<String> names);

  Optional<Email> findByContent(String content);

}
