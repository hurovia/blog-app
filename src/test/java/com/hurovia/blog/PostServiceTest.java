package com.hurovia.blog;

import com.hurovia.blog.exception.PostNotFoundException;
import com.hurovia.blog.post.dto.PostResponse;
import com.hurovia.blog.post.entity.Post;
import com.hurovia.blog.post.mapper.PostMapper;
import com.hurovia.blog.post.repository.PostRepository;
import com.hurovia.blog.post.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    PostRepository postRepository;

    @Mock
    PostMapper createPostMapper;

    @InjectMocks
    PostService postService;

    @Test
    public void testFindPostById_SuccessfullyFetched() {
        Long postId = 1L;
        Post post = new Post(1L, "Test blog title", "Title of blog");

        PostResponse expectedResponse = new PostResponse(
                "Test blog title",
                "Title of blog",
                Instant.now()
        );
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        when(createPostMapper.toPostResponseDTO(post)).thenReturn(expectedResponse);

        PostResponse actualResponse = postService.findById(postId);
        Assertions.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void testFindPostById_FailedToFetchPost() {
        Long postId = 1L;
        when(postRepository.findById(postId)).thenThrow(PostNotFoundException.class);
        Assertions.assertThrows(PostNotFoundException.class, ()->{
            postService.findById(postId);
        });
    }
}
