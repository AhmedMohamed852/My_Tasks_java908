package spring_Tasks_Project.service.Impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.Post_Dto;
import spring_Tasks_Project.mapper.Post_Mapper;
import spring_Tasks_Project.model.Post;
import spring_Tasks_Project.model.Users;
import spring_Tasks_Project.reposatory.Post_Repo;
import spring_Tasks_Project.reposatory.User_Repo;
import spring_Tasks_Project.service.Post_Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Post_Impl implements Post_Service {

    private final Post_Repo post_Repo;
    private final Post_Mapper post_Mapper;
    private final User_Repo user_Repo;

    @Autowired
    public Post_Impl(Post_Repo post_Repo , Post_Mapper post_Mapper , User_Repo user_Repo) {
        this.post_Repo = post_Repo;
        this.post_Mapper = post_Mapper;
        this.user_Repo = user_Repo;
    }



//_________________________________________________________________________


    @Override
    public Post_Dto savePost(Post_Dto post_Dto) {
        Optional<Users> user = user_Repo.findByid(post_Dto.getUsers().getId());

        if(user.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        post_Dto.setUsers(user.get());


        return post_Mapper.toDto(post_Repo.save(post_Mapper.toEntity(post_Dto)));
    }


//_________________________________________________________________________


    @Override
    public Post_Dto getPostById(Long id) {
        Optional<Post> post = post_Repo.findById(id);
        if(post.isEmpty())
        {
            throw new RuntimeException("Post not found");
        }

        return post_Mapper.toDto(post.get());
    }


//_________________________________________________________________________


    @Override
    public void deletePostById(Long id) {
        Optional<Post> post = post_Repo.findById(id);
        if(post.isEmpty())
        {
            throw new RuntimeException("Post not found");
        }

        post_Repo.deleteById(id);

    }


//_________________________________________________________________________

    @Override
    public Post_Dto updatePost(Post_Dto post_Dto) {
        Optional<Post> post = post_Repo.findById(post_Dto.getId());

        if(post.isEmpty())
        {
            throw new RuntimeException("Post not found");
        }
        post_Dto.setUsers(post.get().getUsers());

        post_Repo.save(post_Mapper.toEntity(post_Dto));
        return post_Dto;
    }


//_________________________________________________________________________

    @Override
    public Iterable<Post_Dto> getAllPosts() {
        return post_Mapper.toDtoList(post_Repo.findAll());
    }

//_________________________________________________________________________


    @Override
    public Iterable<Post_Dto> getPostsByUserId(Long id) {

        Optional<List<Post>> post = post_Repo.findAllByusers_id(id);

        if(post.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        return post_Mapper.toDtoList(post.get());
    }


//_________________________________________________________________________

}
