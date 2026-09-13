package com.hurovia.blog.post.dto;

import org.springframework.data.domain.Sort;

import java.util.List;

public record GetPageRequest(
        int size,
        int page,
        String field,
        Boolean sortTo
) {
}
