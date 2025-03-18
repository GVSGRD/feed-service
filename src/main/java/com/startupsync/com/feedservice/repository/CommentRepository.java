package com.startupsync.com.feedservice.repository;

import com.startupsync.com.feedservice.entity.Comment;
import com.startupsync.com.feedservice.entity.Like;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}