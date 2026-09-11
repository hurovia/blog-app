package com.hurovia.blog.post.service;

import com.hurovia.blog.post.entity.Post;
import com.hurovia.blog.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Post save(Post post) {
        return postRepository.save(post);
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
