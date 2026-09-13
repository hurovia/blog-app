package com.hurovia.blog.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
@Schema(description = "Response DTO to return created Post data")
public record PostResponse(
        @Schema(description = "Title of the post")
        String title,
        @Schema(description = "Description of the post")
        String content,
        @Schema(description = "Post created date")
        Instant createdDate
){}