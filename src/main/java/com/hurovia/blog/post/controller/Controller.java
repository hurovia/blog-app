package com.hurovia.blog.post.controller;

import com.hurovia.blog.exception.InvalidInputException;
import com.hurovia.blog.post.dto.*;
import com.hurovia.blog.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest createPostRequest){
        CreatePostResponse createPostResponse = postService.save(createPostRequest);
        return new ResponseEntity<>(createPostResponse, HttpStatus.CREATED);
    }

    @GetMapping("/findpost")
    public ResponseEntity<PostResponse> findPost(@RequestBody PostRequest postRequest){
        PostResponse postResponse = postService.findById(postRequest.postId());
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

//  TODO: This endpoint to fetch all posts will be removed predeployment
    @GetMapping("/findposts")
    public ResponseEntity<List<PostResponse>> allPosts(){
        List<PostResponse> postResponseList = postService.findAll();
        return new ResponseEntity<>(postResponseList, HttpStatus.OK);
    }

//  will hide the page and size from the URL if required in future
    @GetMapping("/findposts/{page}/{size}")
    public ResponseEntity<List<PostResponse>> findPosts(@PathVariable Integer page, @PathVariable Integer size){
        List<PostResponse> postResponseList = postService.findByPage(page-1, size);
        if(postResponseList.isEmpty()){
            throw new InvalidInputException("NO POSTS FOUND IN THIS PAGE");
        }
        return new ResponseEntity<>(postResponseList, HttpStatus.OK);
    }

    @GetMapping("/findAndSort")
    public ResponseEntity<List<PostResponse>> findAndSortByPage(@RequestBody GetPageRequest getPageRequest){
        List<PostResponse> postResponseList = postService.findAndSortByPage(getPageRequest);
        return new ResponseEntity<>(postResponseList, HttpStatus.OK);
    }
}
