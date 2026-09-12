package com.hurovia.blog.post.mapper;


import com.hurovia.blog.post.dto.*;
import com.hurovia.blog.post.entity.Post;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(CreatePostRequest dto);
    CreatePostResponse toCreatePostResponseDTO(Post post);
    PostResponse toPostResponseDTO(Post post);
    List<PostResponse> toPostResponseDTO(List<Post> posts);
}