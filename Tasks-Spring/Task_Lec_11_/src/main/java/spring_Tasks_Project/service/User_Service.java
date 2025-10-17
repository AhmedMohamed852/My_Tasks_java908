package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.User_Dto;

public interface User_Service {

    User_Dto saveUser(User_Dto user_Dto);

    User_Dto getUserById(Long id);

    void deleteUserById(Long id);

    User_Dto updateUser(User_Dto user_Dto);

    Iterable<User_Dto> getAllUsers();
}
