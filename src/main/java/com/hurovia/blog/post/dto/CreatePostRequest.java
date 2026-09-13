package com.hurovia.blog.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Data Transfer Object(DTO) to request data creation")
public record CreatePostRequest(
    @Schema(description = "Title for the blog post")
    String title,

    @Schema(description = "Description of the blog post")
    String content
) {}