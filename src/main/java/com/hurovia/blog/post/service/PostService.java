package com.hurovia.blog.post.service;

import com.hurovia.blog.post.dto.CreatePostRequest;
import com.hurovia.blog.post.dto.CreatePostResponse;
import com.hurovia.blog.post.dto.PostResponse;
import com.hurovia.blog.post.entity.Post;
import com.hurovia.blog.post.mapper.PostMapper;
import com.hurovia.blog.post.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper createPostMapper;

    public PostService(PostRepository postRepository, PostMapper createPostMapper) {
        this.postRepository = postRepository;
        this.createPostMapper = createPostMapper;
    }

    public CreatePostResponse save(CreatePostRequest createPostRequest) {
        Post post = createPostMapper.toEntity(createPostRequest);
        Post savedPost = postRepository.save(post);
        return createPostMapper.toCreatePostResponseDTO(savedPost);
    }

    public List<PostResponse> findAll() {
        return createPostMapper.toPostResponseDTO(postRepository.findAll());
    }
    public PostResponse findById(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        return createPostMapper.toPostResponseDTO(post);
    }

    public List<PostResponse> findByPage(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return createPostMapper.toPostResponseDTO(postRepository.findAll(pageRequest).getContent());
    }
}
