package com.example.filmback.service;

import com.example.filmback.entity.Comment;
import com.example.filmback.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    final
    CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment){
        this.commentRepository.save(comment);
    }

    public List<Comment> getComments(Long movieId){
        return  this.commentRepository.findCommentsByMovieId(movieId);
    }
}
