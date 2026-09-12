package com.hurovia.blog.post.service;

import com.hurovia.blog.post.dto.CreatePostRequest;
import com.hurovia.blog.post.dto.CreatePostResponse;
import com.hurovia.blog.post.entity.Post;
import com.hurovia.blog.post.mapper.PostMapper;
import com.hurovia.blog.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
    public Post update(Post post) {
        return postRepository.save(post);
    }
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
