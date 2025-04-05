<template>
  <div class="search">
    <h1>Search Results</h1>
    <div class="search-form">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search posts..."
        @keyup.enter="search"
      />
      <button @click="search">Search</button>
    </div>
    <div class="results" v-if="results.length > 0">
      <div v-for="post in results" :key="post.id" class="result-item">
        <router-link :to="'/post/' + post.id" class="result-link">
          <h3 class="result-title">{{ post.title }}</h3>
          <p class="result-excerpt">{{ post.excerpt }}</p>
          <div class="result-meta">
            <span class="result-date">{{ formatDate(post.date) }}</span>
            <div class="result-tags">
              <span v-for="tag in post.tags" :key="tag" class="tag">{{ tag }}</span>
            </div>
          </div>
        </router-link>
      </div>
    </div>
    <div v-else class="no-results">
      <p>No results found for "{{ searchQuery }}"</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

interface Post {
  id: number
  title: string
  excerpt: string
  date: string
  tags: string[]
}

const route = useRoute()
const router = useRouter()
const searchQuery = ref((route.query.q as string) || '')
const results = ref<Post[]>([])

onMounted(async () => {
  if (searchQuery.value) {
    await search()
  }
})

const search = async () => {
  try {
    const response = await axios.get(
      `http://localhost:28081/api/posts/search?keyword=${searchQuery.value}`,
    )
    results.value = response.data
  } catch (error) {
    console.error('Error searching posts:', error)
  }
}

const formatDate = (dateString: string) => {
  return new Date(dateString).toLocaleDateString('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
  })
}
</script>

<style scoped>
.search {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.search-form {
  display: flex;
  gap: 1rem;
  margin: 2rem 0;
}

.search-form input {
  flex: 1;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.search-form button {
  padding: 0.5rem 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.search-form button:hover {
  background-color: #0056b3;
}

.results {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.result-item {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 1.5rem;
}

.result-link {
  text-decoration: none;
  color: inherit;
}

.result-title {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
  color: #333;
}

.result-excerpt {
  color: #444;
  line-height: 1.6;
  margin-bottom: 1rem;
}

.result-meta {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.result-date {
  color: #666;
  font-size: 0.9rem;
}

.result-tags {
  display: flex;
  gap: 0.5rem;
}

.tag {
  background-color: #f0f0f0;
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.8rem;
  color: #666;
}

.no-results {
  text-align: center;
  padding: 2rem;
  color: #666;
}
</style>
