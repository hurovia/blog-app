package com.hurovia.blog.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Used to fetch post based on postId")
public record PostRequest (
   @Schema(description = "Post Id required to fetch post")
   Long postId
) {}