package com.example.filmback.repository;

import com.example.filmback.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findCommentsByMovieId(Long movieId);
}
