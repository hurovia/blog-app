package com.hurovia.blog.post.dto;

import java.time.Instant;

public record CreatePostRequest(
    String title,
    String content
) {}