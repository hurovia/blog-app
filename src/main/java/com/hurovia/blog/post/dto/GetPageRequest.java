package com.hurovia.blog.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Used to sort pages")
public record GetPageRequest(
        @Schema(description = "Provides size per page")
        int size,
        @Schema(description = "Page number")
        int page,
        @Schema(description = "Field used to sort the page")
        String field,
        @Schema(description = "Value used to sort ASC/DESC")
        Boolean sortTo
) {
}
