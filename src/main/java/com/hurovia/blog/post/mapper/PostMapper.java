package com.hurovia.blog.post.mapper;


import com.hurovia.blog.post.dto.CreatePostRequest;
import com.hurovia.blog.post.dto.CreatePostResponse;
import com.hurovia.blog.post.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(CreatePostRequest dto);
    CreatePostResponse toCreatePostResponseDTO(Post post);
}