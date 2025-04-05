<template>
  <div class="page-container">
    <section class="hero section-card">
      <div class="hero-content">
        <h1 class="welcome-title">Welcome to Jxun-h Blog! 👨‍💻</h1>
        <p class="hero-description">개발과 관련된 다양한 주제를 공유하는 블로그입니다.</p>
      </div>
    </section>

    <section class="featured-topics section-card">
      <h2 class="section-title">주요 주제</h2>
      <div class="grid-container col-4">
        <div class="topic-card item-card">
          <div class="topic-icon">📊</div>
          <h3>알고리즘</h3>
          <p>알고리즘 문제 풀이와 해설을 공유합니다.</p>
        </div>
        <div class="topic-card item-card">
          <div class="topic-icon">⚙️</div>
          <h3>백엔드 개발</h3>
          <p>Spring Boot, MySQL 등 백엔드 기술을 다룹니다.</p>
        </div>
        <div class="topic-card item-card">
          <div class="topic-icon">🔍</div>
          <h3>문제 해결</h3>
          <p>개발 중 마주친 문제와 해결 방법을 공유합니다.</p>
        </div>
        <div class="topic-card item-card">
          <div class="topic-icon">📚</div>
          <h3>기술 학습</h3>
          <p>새로운 기술 스택 학습 내용을 정리합니다.</p>
        </div>
      </div>
    </section>

    <section class="recent-posts section-card">
      <h2 class="section-title">최근 포스트</h2>
      <div v-if="posts.length > 0" class="grid-container col-3">
        <div v-for="post in posts" :key="post.id" class="post-card item-card">
          <router-link :to="'/post/' + post.id" class="post-link">
            <div class="post-header">
              <h3 class="post-title">{{ post.title }}</h3>
              <span class="post-date">{{ formatDate(post.date) }}</span>
            </div>
            <p class="post-excerpt">{{ post.excerpt }}</p>
            <div class="post-tags">
              <span v-for="tag in post.tags" :key="tag" class="tag">{{ tag }}</span>
            </div>
          </router-link>
        </div>
      </div>
      <div v-else class="no-posts">
        <p>아직 포스트가 없습니다. 곧 새로운 글이 업로드될 예정입니다.</p>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

interface Post {
  id: number
  title: string
  date: string
  excerpt: string
  tags: string[]
}

const posts = ref<Post[]>([
  // 더미 데이터
  {
    id: 1,
    title: 'Spring Boot에서 JPA 활용하기',
    date: '2024-04-10',
    excerpt: 'Spring Boot 애플리케이션에서 JPA를 효과적으로 활용하는 방법에 대해 알아봅니다.',
    tags: ['Spring Boot', 'JPA', '백엔드'],
  },
  {
    id: 2,
    title: 'Vue 3 Composition API 완벽 가이드',
    date: '2024-04-05',
    excerpt:
      'Vue 3의 Composition API를 사용하여 더 유연하고 재사용 가능한 컴포넌트를 만드는 방법을 알아봅니다.',
    tags: ['Vue', 'Frontend', 'JavaScript'],
  },
  {
    id: 3,
    title: 'Docker 컨테이너 최적화 팁',
    date: '2024-03-28',
    excerpt: 'Docker 컨테이너 크기를 줄이고 성능을 개선하는 10가지 팁을 소개합니다.',
    tags: ['Docker', 'DevOps', '성능 최적화'],
  },
])

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:28081/api/posts')
    if (response.data && response.data.length > 0) {
      posts.value = response.data
    }
    // API 호출 실패해도 더미 데이터 유지
  } catch (error) {
    console.error('Error fetching posts:', error)
    // 더미 데이터 유지
  }
})

const formatDate = (dateString: string) => {
  return new Date(dateString).toLocaleDateString('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
  })
}
</script>

<style scoped>
.page-container {
  max-width: 1584px;
  margin: 0 auto;
  padding: 0 1rem;
}

.section-title {
  text-align: center;
  margin-bottom: 2rem;
  font-size: 1.5rem;
  font-weight: 600;
  color: var(--text-color);
}

.hero {
  background: var(--primary-color);
  color: white;
  padding: 3rem 2rem;
  margin-top: 2rem;
}

.hero-content {
  max-width: 900px;
  margin: 0 auto;
}

.welcome-title {
  font-size: 2rem;
  margin-bottom: 1rem;
  font-weight: 700;
}

.hero-description {
  font-size: 1.1rem;
  opacity: 0.9;
}

.featured-topics {
  margin-bottom: 3rem;
}

.topics-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1.5rem;
}

.topic-card {
  background: var(--card-background);
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: var(--card-shadow);
  text-align: center;
  transition: transform 0.2s ease;
}

.topic-card:hover {
  transform: translateY(-3px);
}

.topic-icon {
  font-size: 2rem;
  margin-bottom: 0.75rem;
}

.topic-card h3 {
  margin-bottom: 0.75rem;
  color: var(--text-color);
  font-size: 1.2rem;
}

.topic-card p {
  color: var(--secondary-color);
  line-height: 1.5;
  font-size: 0.95rem;
}

.recent-posts {
  margin-bottom: 3rem;
}

.post-list {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 1.5rem;
}

.post-card {
  background: var(--card-background);
  border-radius: 8px;
  box-shadow: var(--card-shadow);
  transition: transform 0.2s ease;
  height: 100%;
}

.post-card:hover {
  transform: translateY(-3px);
}

.post-link {
  text-decoration: none;
  color: inherit;
  display: block;
  padding: 1.5rem;
  height: 100%;
  display: flex;
  flex-direction: column;
}

.post-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 0.75rem;
  flex-wrap: wrap;
}

.post-title {
  font-size: 1.25rem;
  color: var(--text-color);
  margin: 0;
  margin-bottom: 0.5rem;
  flex: 1;
  min-width: 100%;
}

.post-date {
  color: var(--secondary-color);
  font-size: 0.85rem;
}

.post-excerpt {
  color: var(--secondary-color);
  line-height: 1.5;
  margin-bottom: 1rem;
  font-size: 0.95rem;
  flex: 1;
}

.post-tags {
  display: flex;
  gap: 0.5rem;
  flex-wrap: wrap;
  margin-top: auto;
}

.tag {
  background-color: var(--search-background);
  padding: 0.25rem 0.75rem;
  border-radius: 20px;
  font-size: 0.75rem;
  color: var(--secondary-color);
}

.no-posts {
  background: var(--card-background);
  padding: 2rem;
  border-radius: 8px;
  text-align: center;
  color: var(--secondary-color);
  grid-column: 1 / -1;
}

@media (max-width: 1024px) {
  .topics-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .post-list {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .welcome-title {
    font-size: 1.75rem;
  }

  .hero {
    padding: 2rem 1rem;
  }

  .topics-grid {
    grid-template-columns: 1fr;
  }

  .post-list {
    grid-template-columns: 1fr;
  }
}
</style>
