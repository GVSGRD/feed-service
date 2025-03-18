package com.startupsync.com.feedservice.controller;

import com.startupsync.com.feedservice.entity.Like;
import com.startupsync.com.feedservice.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/create")
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like createdLike = likeService.createLike(like);
        return new ResponseEntity<>(createdLike, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Like> getLikeById(@PathVariable Long id) {
        Like like = likeService.getLikeById(id);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Like>> getAllLikes() {
        List<Like> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Like> updateLike(@RequestBody Like like) {
        Like updatedLike = likeService.updateLike(like);
        return new ResponseEntity<>(updatedLike, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> findByPostId(@PathVariable Long postId) {
        List<Like> likedPosts = likeService.findByPostId(postId);
        return new ResponseEntity<>(likedPosts, HttpStatus.OK);
    }
}