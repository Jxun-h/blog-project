package com.blog.controller;

import com.blog.entity.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:28080")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        
        // 데이터가 없으면 더미 데이터 반환
        if (posts.isEmpty()) {
            return getDummyPosts();
        }
        
        return posts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        // 테스트용 더미 데이터 반환
        if (id <= 3) {
            Post dummyPost = getDummyPost(id);
            if (dummyPost != null) {
                return ResponseEntity.ok(dummyPost);
            }
        }
        
        return postRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Post> searchPosts(@RequestParam String keyword) {
        List<Post> posts = postRepository.searchByKeyword(keyword);
        
        // 검색 결과가 없으면 일부 더미 데이터만 반환
        if (posts.isEmpty()) {
            return getDummyPosts().stream()
                .filter(post -> post.getTitle().toLowerCase().contains(keyword.toLowerCase()) || 
                        post.getContent().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        }
        
        return posts;
    }

    @GetMapping("/tags")
    public List<Post> getPostsByTags(@RequestParam List<String> tags) {
        return postRepository.findByTags(tags);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(postDetails.getTitle());
                    post.setContent(postDetails.getContent());
                    post.setExcerpt(postDetails.getExcerpt());
                    post.setTags(postDetails.getTags());
                    return ResponseEntity.ok(postRepository.save(post));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    postRepository.delete(post);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // 더미 데이터 생성 메소드
    private List<Post> getDummyPosts() {
        List<Post> dummyPosts = new ArrayList<>();
        
        // 더미 포스트 1
        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("Spring Boot에서 JPA 활용하기");
        post1.setExcerpt("Spring Boot 애플리케이션에서 JPA를 효과적으로 활용하는 방법에 대해 알아봅니다.");
        post1.setContent("<h2>JPA란?</h2><p>JPA(Java Persistence API)는 자바 ORM 기술에 대한 API 표준 명세로, 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스입니다.</p><h2>Spring Boot에서 JPA 설정하기</h2><p>Spring Boot에서는 spring-boot-starter-data-jpa 의존성을 추가하여 손쉽게 JPA를 사용할 수 있습니다.</p><h2>엔티티 설계하기</h2><p>JPA에서 가장 중요한 것은 엔티티의 설계입니다. 엔티티 간의 관계를 올바르게 정의하고, 적절한 어노테이션을 사용하여 엔티티를 정의합니다.</p>");
        post1.setCreatedAt(LocalDateTime.now().minusDays(5));
        post1.setUpdatedAt(LocalDateTime.now().minusDays(5));
        Set<String> tags1 = new HashSet<>();
        tags1.add("Spring Boot");
        tags1.add("JPA");
        tags1.add("백엔드");
        post1.setTags(tags1);
        dummyPosts.add(post1);
        
        // 더미 포스트 2
        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("Vue 3 Composition API 완벽 가이드");
        post2.setExcerpt("Vue 3의 Composition API를 사용하여 더 유연하고 재사용 가능한 컴포넌트를 만드는 방법을 알아봅니다.");
        post2.setContent("<h2>Composition API란?</h2><p>Vue 3에서 도입된 Composition API는 컴포넌트 로직을 더 유연하게 구성할 수 있도록 해주는 새로운 API입니다.</p><h2>ref와 reactive</h2><p>Composition API에서는 ref와 reactive를 사용하여 반응형 상태를 정의할 수 있습니다.</p><h2>Computed와 Watch</h2><p>computed()와 watch()를 사용하여 반응형 상태를 기반으로 계산된 값과 부수 효과를 정의할 수 있습니다.</p>");
        post2.setCreatedAt(LocalDateTime.now().minusDays(10));
        post2.setUpdatedAt(LocalDateTime.now().minusDays(8));
        Set<String> tags2 = new HashSet<>();
        tags2.add("Vue");
        tags2.add("Frontend");
        tags2.add("JavaScript");
        post2.setTags(tags2);
        dummyPosts.add(post2);
        
        // 더미 포스트 3
        Post post3 = new Post();
        post3.setId(3L);
        post3.setTitle("Docker 컨테이너 최적화 팁");
        post3.setExcerpt("Docker 컨테이너 크기를 줄이고 성능을 개선하는 10가지 팁을 소개합니다.");
        post3.setContent("<h2>Dockerfile 최적화</h2><p>Dockerfile을 작성할 때 레이어를 최소화하고, 불필요한 파일을 제거하여 이미지 크기를 줄입니다.</p><h2>다단계 빌드 사용하기</h2><p>다단계 빌드를 사용하여 빌드 환경과 실행 환경을 분리함으로써 최종 이미지 크기를 줄일 수 있습니다.</p><h2>적절한 베이스 이미지 선택</h2><p>애플리케이션에 필요한 최소한의 기능만 포함된 가벼운 베이스 이미지를 선택합니다.</p>");
        post3.setCreatedAt(LocalDateTime.now().minusDays(15));
        post3.setUpdatedAt(LocalDateTime.now().minusDays(15));
        Set<String> tags3 = new HashSet<>();
        tags3.add("Docker");
        tags3.add("DevOps");
        tags3.add("성능 최적화");
        post3.setTags(tags3);
        dummyPosts.add(post3);
        
        return dummyPosts;
    }
    
    private Post getDummyPost(Long id) {
        return getDummyPosts().stream()
            .filter(post -> post.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
} 