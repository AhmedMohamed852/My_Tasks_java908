package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import spring_Tasks_Project.dto.User_Dto;
import spring_Tasks_Project.model.Users;

import java.util.List;

@Mapper(componentModel = "spring")
public interface User_Mapper {

   Users toEntity(User_Dto user_dto);
   User_Dto toDto(Users user);

   List<User_Dto> toDtoList(List<Users> userList);
}
