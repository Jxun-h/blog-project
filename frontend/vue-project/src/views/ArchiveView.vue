<template>
  <div class="archive">
    <h1>Archive</h1>
    <div class="content">
      <div v-for="(posts, year) in archivedPosts" :key="year" class="year-section">
        <h2>{{ year }}</h2>
        <div class="post-list">
          <div v-for="post in posts" :key="post.id" class="post-item">
            <router-link :to="'/post/' + post.id" class="post-link">
              <span class="post-date">{{ formatDate(post.date) }}</span>
              <span class="post-title">{{ post.title }}</span>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

interface Post {
  id: number
  title: string
  date: string
}

const archivedPosts = ref<Record<string, Post[]>>({})

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:28081/api/posts')
    const posts = response.data
    const groupedPosts = posts.reduce((acc: Record<string, Post[]>, post: Post) => {
      const year = new Date(post.date).getFullYear().toString()
      if (!acc[year]) {
        acc[year] = []
      }
      acc[year].push(post)
      return acc
    }, {})
    archivedPosts.value = groupedPosts
  } catch (error) {
    console.error('Error fetching posts:', error)
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
.archive {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.year-section {
  margin-bottom: 2rem;
}

.year-section h2 {
  margin-bottom: 1rem;
  color: #333;
}

.post-list {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.post-item {
  padding: 0.5rem 0;
}

.post-link {
  text-decoration: none;
  color: inherit;
  display: flex;
  gap: 1rem;
}

.post-date {
  color: #666;
  min-width: 100px;
}

.post-title:hover {
  color: #007bff;
}
</style>
