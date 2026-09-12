package com.hurovia.blog.post.controller;

import com.hurovia.blog.post.dto.CreatePostRequest;
import com.hurovia.blog.post.dto.CreatePostResponse;
import com.hurovia.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    private final PostService postService;

    public Controller(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createpost")
    public CreatePostResponse createPost(@RequestBody CreatePostRequest createPostRequest){
        return postService.save(createPostRequest);
    }
}
