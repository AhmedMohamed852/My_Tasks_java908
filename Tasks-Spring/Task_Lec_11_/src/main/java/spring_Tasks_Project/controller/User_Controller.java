package spring_Tasks_Project.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_Tasks_Project.dto.User_Dto;
import spring_Tasks_Project.service.User_Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class User_Controller {

    private final User_Service user_Service;
    public User_Controller(User_Service user_Service)
    {
        this.user_Service = user_Service;
    }

//_____________________________________________________________

    @PostMapping("/saveUser")
    public ResponseEntity<User_Dto> saveUser(@RequestBody @Valid User_Dto user_dto) throws URISyntaxException
    {
        return ResponseEntity.created(new URI("/saveUser")).body(user_Service.saveUser(user_dto));
    }

//_____________________________________________________________

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User_Dto> getUserById(@PathVariable Long id)
    {
        return ResponseEntity.ok(user_Service.getUserById(id));
    }

//_____________________________________________________________



    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id)
    {
        user_Service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }


//_____________________________________________________________

    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<User_Dto>> getAllUsers()
    {
        return ResponseEntity.ok(user_Service.getAllUsers());
    }


//_____________________________________________________________



}
