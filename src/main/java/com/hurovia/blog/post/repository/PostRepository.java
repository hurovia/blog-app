package com.hurovia.blog.post.repository;

import com.hurovia.blog.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class PostRepository implements JpaRepository<Post, Long> {
    //Using available methods
}
