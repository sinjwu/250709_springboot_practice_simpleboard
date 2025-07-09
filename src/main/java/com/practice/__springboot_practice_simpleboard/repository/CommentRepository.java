package com.practice.__springboot_practice_simpleboard.repository;

import com.practice.__springboot_practice_simpleboard.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
