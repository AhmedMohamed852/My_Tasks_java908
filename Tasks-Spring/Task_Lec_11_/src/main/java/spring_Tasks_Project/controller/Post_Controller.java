package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.Post_Dto;
import spring_Tasks_Project.service.Post_Service;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class Post_Controller {

    private final Post_Service post_Service;
    @Autowired
    public Post_Controller(Post_Service post_Service)
    {
        this.post_Service = post_Service;
    }

//_____________________________________________________________

    @PostMapping("/savePost")
    public ResponseEntity<Post_Dto> savePost(@RequestBody  @Valid Post_Dto post_Dto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/savePost")).body(post_Service.savePost(post_Dto ));
    }

//_____________________________________________________________


    @GetMapping("/getPostById/{id}")
    public ResponseEntity<Post_Dto> getPostById(@PathVariable Long id)
    {
        return ResponseEntity.ok(post_Service.getPostById(id));
    }


//_____________________________________________________________


    @PutMapping("/updatePost")
    public ResponseEntity<Post_Dto> updatePost(@RequestBody @Valid Post_Dto post_Dto)
    {
        return ResponseEntity.ok(post_Service.updatePost(post_Dto));
    }


//_____________________________________________________________


    @DeleteMapping("/deletePostById/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id)
    {
        post_Service.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

//_____________________________________________________________



    @GetMapping("/getAllPosts")
    public ResponseEntity<Iterable<Post_Dto>> getAllPosts()
    {
        return ResponseEntity.ok(post_Service.getAllPosts());
    }

//_____________________________________________________________


    @GetMapping("/getPostsByUserId/{id}")
    public ResponseEntity<Iterable<Post_Dto>> getPostsByUserId(@PathVariable Long id)
    {
        return ResponseEntity.ok(post_Service.getPostsByUserId(id));
    }

//_____________________________________________________________

}
