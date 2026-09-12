package com.hurovia.blog.post.dto;


import java.time.Instant;

public record CreatePostResponse(
        String postId,
        String title,
        String content,
        Instant createdDate
) {}
