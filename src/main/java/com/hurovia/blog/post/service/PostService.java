package com.hurovia.blog.post.service;

import com.hurovia.blog.exception.PersistenceException;
import com.hurovia.blog.exception.PostNotFoundException;
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
        try {
            Post post = createPostMapper.toEntity(createPostRequest);
            Post savedPost = postRepository.save(post);
            return createPostMapper.toCreatePostResponseDTO(savedPost);
        } catch (Exception e) {
            throw new PersistenceException("FAILED TO SAVE POST");
        }
    }

    public List<PostResponse> findAll() {
        try {
            return createPostMapper.toPostResponseDTO(postRepository.findAll());
        } catch (Exception e) {
            throw new PersistenceException("FAILED TO FIND ALL POSTS");
        }
    }
    public PostResponse findById(Long postId) {
        try {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new PostNotFoundException("POST ID: "+postId+", NOT FOUND"));
            return createPostMapper.toPostResponseDTO(post);
        } catch (PostNotFoundException e) {
            throw new PersistenceException("FAILED TO FIND POST");
        }
    }

    public List<PostResponse> findByPage(int page, int pageSize) {
        try {
            PageRequest pageRequest = PageRequest.of(page, pageSize);
            return createPostMapper.toPostResponseDTO(postRepository.findAll(pageRequest).getContent());
        } catch (Exception e) {
            throw new  PersistenceException("UNABLE TO FIND POSTS");
        }
    }
}
