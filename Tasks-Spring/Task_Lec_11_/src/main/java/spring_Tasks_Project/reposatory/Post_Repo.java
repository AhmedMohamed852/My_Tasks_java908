package spring_Tasks_Project.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_Tasks_Project.model.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface Post_Repo extends JpaRepository<Post,Long> {

    Optional<List<Post>> findAllByusers_id(Long userId);
}
