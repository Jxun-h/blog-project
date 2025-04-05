<template>
  <div class="home">
    <h1 class="welcome-title">Welcome to My Blog! 🙋🏻‍♂️💻</h1>

    <div class="blog-description">
      <p>이 블로그에서는 아래와 같은 다양한 주제를 포스팅합니다.</p>
      <ul>
        <li>알고리즘 문제 풀이</li>
        <li>백엔드 개발 관련 내용</li>
        <li>개발하면서 겪은 문제 해결 경험</li>
        <li>기술 스택 학습 내용</li>
      </ul>
    </div>

    <div class="recent-posts">
      <h2>Recent Posts</h2>
      <div class="post-list">
        <div v-for="post in posts" :key="post.id" class="post-card">
          <router-link :to="'/post/' + post.id" class="post-link">
            <h3 class="post-title">{{ post.title }}</h3>
            <p class="post-date">{{ post.date }}</p>
            <p class="post-excerpt">{{ post.excerpt }}</p>
            <div class="post-tags">
              <span v-for="tag in post.tags" :key="tag" class="tag">{{ tag }}</span>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const posts = ref([])

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:28081/api/posts')
    posts.value = response.data
  } catch (error) {
    console.error('Error fetching posts:', error)
  }
})
</script>

<style scoped>
.home {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.welcome-title {
  font-size: 2.5rem;
  margin-bottom: 2rem;
  text-align: center;
}

.blog-description {
  margin-bottom: 3rem;
  line-height: 1.6;
}

.blog-description ul {
  list-style-type: disc;
  padding-left: 2rem;
  margin-top: 1rem;
}

.recent-posts {
  margin-top: 3rem;
}

.post-list {
  display: grid;
  gap: 2rem;
}

.post-card {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 1.5rem;
  transition: transform 0.2s;
}

.post-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.post-link {
  text-decoration: none;
  color: inherit;
}

.post-title {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
  color: #333;
}

.post-date {
  color: #666;
  font-size: 0.9rem;
  margin-bottom: 1rem;
}

.post-excerpt {
  color: #444;
  line-height: 1.6;
  margin-bottom: 1rem;
}

.post-tags {
  display: flex;
  gap: 0.5rem;
  flex-wrap: wrap;
}

.tag {
  background-color: #f0f0f0;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.8rem;
  color: #666;
}
</style>
