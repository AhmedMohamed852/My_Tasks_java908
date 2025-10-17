package spring_Tasks_Project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_Tasks_Project.dto.User_Dto;
import spring_Tasks_Project.mapper.User_Mapper;
import spring_Tasks_Project.model.Users;
import spring_Tasks_Project.reposatory.User_Repo;
import spring_Tasks_Project.service.User_Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class User_Impl implements User_Service {

    private final User_Repo user_Repo;
    private final User_Mapper user_Mapper;

    @Autowired
    public User_Impl(User_Repo user_Repo , User_Mapper user_Mapper)
    {
        this.user_Repo = user_Repo;
        this.user_Mapper = user_Mapper;
    }

//________________________________________________________________


    @Override
    public void deleteUserById(Long id)
    {
        Optional<Users> user = user_Repo.findById(id);
        if(user.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        user_Repo.deleteById(id);
    }


//________________________________________________________________


    @Override
    public User_Dto updateUser(User_Dto user_Dto)
    {
        Optional<Users> user = user_Repo.findById(user_Dto.getId());
        if(user.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        if (Objects.isNull(user_Dto.getId()))
        {
            throw new RuntimeException("user Id Must Be Not Null");
        }

        user_Repo.save(user_Mapper.toEntity(user_Dto));
        return user_Dto;
    }

//________________________________________________________________


    @Override
    public User_Dto saveUser(User_Dto user_Dto)
    {
        Optional<Users> user = user_Repo.findByname(user_Dto.getName());

        if(Objects.nonNull(user_Dto.getId()))
        {
            throw new RuntimeException("User already exists");
        }

        if(user.isPresent())
        {
            throw new RuntimeException("User already exists");
        }

        user_Repo.save(user_Mapper.toEntity(user_Dto));
        return user_Dto;
    }

//________________________________________________________________


    @Override
    public User_Dto getUserById(Long id)
    {
        Optional<Users> user = user_Repo.findById(id);
        if(user.isEmpty())
        {
            throw new RuntimeException("User not found");
        }
        return user_Mapper.toDto(user.get());
    }

//________________________________________________________________


    @Override
    public Iterable<User_Dto> getAllUsers()
    {
        return user_Mapper.toDtoList(user_Repo.findAll());
    }


//________________________________________________________________


}
