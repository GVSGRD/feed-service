package com.startupsync.com.feedservice.service;

import com.startupsync.com.feedservice.entity.Like;
import com.startupsync.com.feedservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    public Like getLikeById(Long id) {
        return likeRepository.findById(id).orElse(null);
    }

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public Like updateLike(Like like) {
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }

    public List<Like> findByPostId(Long postId){
        return likeRepository.findByPostId(postId);
    }
}