package com.hurovia.blog.post.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

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

    public Post(Long postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
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

    public Post(){

    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Lob
    @Column(name = "post_content", columnDefinition = "MEDIUMTEXT")
    private String content;

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    @CreationTimestamp
    @Column(name = "time_posted", updatable = false, nullable = false)
    private Instant createdDate;
}
