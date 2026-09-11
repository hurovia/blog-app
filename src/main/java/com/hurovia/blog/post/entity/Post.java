package com.hurovia.blog.post.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "posts")
public class Post {
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", updatable = false, nullable = false)
    private Long postId;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Lob
    @Column(name = "post_content", columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name = "time_posted", updatable = false, nullable = false)
    private Instant createdDate;
}
