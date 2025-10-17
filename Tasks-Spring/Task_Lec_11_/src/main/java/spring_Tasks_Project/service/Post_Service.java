package spring_Tasks_Project.service;

import spring_Tasks_Project.dto.Post_Dto;

public interface Post_Service {

    Post_Dto savePost(Post_Dto post_Dto);

    Post_Dto getPostById(Long id);

    void deletePostById(Long id);

    Post_Dto updatePost(Post_Dto post_Dto);

    Iterable<Post_Dto> getAllPosts();

    Iterable<Post_Dto> getPostsByUserId(Long id);
}
