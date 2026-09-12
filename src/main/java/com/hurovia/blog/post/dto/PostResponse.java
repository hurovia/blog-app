package com.hurovia.blog.post.dto;

import com.hurovia.blog.post.entity.Post;

import java.time.Instant;

public record PostResponse(
        String title,
        String content,
        Instant createdDate
){}