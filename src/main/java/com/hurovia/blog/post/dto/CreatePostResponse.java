package com.hurovia.blog.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Response DTO to show data persisted")
public record CreatePostResponse(
        @Schema(description = "Unique Id of each post")
        String postId,
        @Schema(description = "Title of the post")
        String title,
        @Schema(description = "Description of the post")
        String content,
        @Schema(description = "Created Date")
        Instant createdDate
) {}
