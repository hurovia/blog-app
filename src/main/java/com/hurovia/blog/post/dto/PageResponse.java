package com.hurovia.blog.post.dto;

import java.util.List;

public record PageResponse(
        List<CreatePostResponse> posts
){}