package spring_Tasks_Project.mapper;

import org.mapstruct.Mapper;
import spring_Tasks_Project.dto.Post_Dto;
import spring_Tasks_Project.model.Post;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Post_Mapper {

   Post toEntity(Post_Dto post_Dto);
   Post_Dto toDto(Post post);
   List<Post_Dto> toDtoList(List<Post> postList);
}
