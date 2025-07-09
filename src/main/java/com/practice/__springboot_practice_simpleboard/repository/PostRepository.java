package com.practice.__springboot_practice_simpleboard.repository;

import com.practice.__springboot_practice_simpleboard.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
