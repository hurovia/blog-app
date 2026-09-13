package com.hurovia.blog.post.service;

import com.hurovia.blog.exception.PersistenceException;
import com.hurovia.blog.exception.PostNotFoundException;
import com.hurovia.blog.post.dto.CreatePostRequest;
import com.hurovia.blog.post.dto.CreatePostResponse;
import com.hurovia.blog.post.dto.GetPageRequest;
import com.hurovia.blog.post.dto.PostResponse;
import com.hurovia.blog.post.entity.Post;
import com.hurovia.blog.post.mapper.PostMapper;
import com.hurovia.blog.post.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper createPostMapper;

    public PostService(PostRepository postRepository, PostMapper createPostMapper) {
        this.postRepository = postRepository;
        this.createPostMapper = createPostMapper;
    }


//    save() tries to persist post data to database
    public CreatePostResponse save(CreatePostRequest createPostRequest) {
        try {
            Post post = createPostMapper.toEntity(createPostRequest);
            Post savedPost = postRepository.save(post);
            return createPostMapper.toCreatePostResponseDTO(savedPost);
        } catch (Exception e) {
            throw new PersistenceException("FAILED TO SAVE POST");
        }
    }

//  findAll() tries to fetch all posts from database
//  TODO: Remove this method predeployment
    public List<PostResponse> findAll() {
        try {
            return createPostMapper.toPostResponseDTO(postRepository.findAll());
        } catch (Exception e) {
            throw new PersistenceException("FAILED TO FETCH ALL POSTS");
        }
    }

//  findById() will fetch post based on postId
    public PostResponse findById(Long postId) {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new PostNotFoundException("POST ID: "+postId+", NOT FOUND"));
            return createPostMapper.toPostResponseDTO(post);
    }

//  findByPage() will fetch posts based on page size and page number
    public List<PostResponse> findByPage(int page, int pageSize) {
        try {
            PageRequest pageRequest = PageRequest.of(page, pageSize);
            return createPostMapper.toPostResponseDTO(postRepository.findAll(pageRequest).getContent());
        } catch (Exception e) {
            throw new  PersistenceException("UNABLE TO FETCH POSTS");
        }
    }

//    findByPageAndSort() method will sort based on field along with functionality by findByPage()
    public List<PostResponse> findAndSortByPage(GetPageRequest getPageRequest){
        try {
            Sort sort = getPageRequest.sortTo()?Sort.by(getPageRequest.field()).ascending():Sort.by(getPageRequest.field()).descending();
            PageRequest pageRequest = PageRequest.of(getPageRequest.page()-1, getPageRequest.size(), sort);
            return createPostMapper.toPostResponseDTO(postRepository.findAll(pageRequest).getContent());
        }catch (Exception e){
            throw new PersistenceException("UNABLE TO FETCH AND SORT POSTS");
        }
    }
}
