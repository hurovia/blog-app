package com.hurovia.blog.post.controller;

import com.hurovia.blog.post.dto.*;
import com.hurovia.blog.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findpost")
    public PostResponse findPost(@RequestBody PostRequest postRequest){
        return postService.findById(postRequest.postId());
    }

    @GetMapping("/allposts")
    public List<PostResponse> allPosts(){
        return postService.findAll();
    }

    @GetMapping("/findposts")
    public List<PostResponse> findPosts(@RequestParam Integer page, @RequestParam Integer size){
        return postService.findByPage(page, size);
    }
}
