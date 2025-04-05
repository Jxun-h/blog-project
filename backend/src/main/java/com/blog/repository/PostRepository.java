package com.blog.repository;

import com.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();
    
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")
    List<Post> searchByKeyword(@Param("keyword") String keyword);
    
    @Query("SELECT DISTINCT p FROM Post p JOIN p.tags t WHERE t IN :tags")
    List<Post> findByTags(@Param("tags") List<String> tags);
} 