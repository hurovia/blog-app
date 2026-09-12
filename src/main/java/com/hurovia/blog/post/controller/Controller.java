package com.hurovia.blog.post.controller;

import com.hurovia.blog.post.dto.*;
import com.hurovia.blog.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private final PostService postService;

    public Controller(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createpost")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest createPostRequest){
        CreatePostResponse createPostResponse = postService.save(createPostRequest);
        return new ResponseEntity<>(createPostResponse, HttpStatus.CREATED);
    }

    @GetMapping("/findpost")
    public ResponseEntity<PostResponse> findPost(@RequestBody PostRequest postRequest){
        PostResponse postResponse = postService.findById(postRequest.postId());
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/allposts")
    public ResponseEntity<List<PostResponse>> allPosts(){
        List<PostResponse> postResponseList = postService.findAll();
        return new ResponseEntity<>(postResponseList, HttpStatus.OK);
    }

    @GetMapping("/findposts")
    public ResponseEntity<List<PostResponse>> findPosts(@RequestParam Integer page, @RequestParam Integer size){
        List<PostResponse> postResponseList = postService.findByPage(page, size);
        return new ResponseEntity<>(postResponseList, HttpStatus.OK);
    }
}
