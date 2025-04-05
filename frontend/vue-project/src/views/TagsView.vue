<template>
  <div class="tags">
    <h1>Tags</h1>
    <div class="content">
      <div class="tag-cloud">
        <router-link
          v-for="tag in tags"
          :key="tag.name"
          :to="'/search?tags=' + tag.name"
          class="tag-item"
          :style="{ fontSize: getTagSize(tag.count) }"
        >
          {{ tag.name }} ({{ tag.count }})
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

interface Tag {
  name: string
  count: number
}

const tags = ref<Tag[]>([])

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:28081/api/posts/tags')
    tags.value = response.data
  } catch (error) {
    console.error('Error fetching tags:', error)
  }
})

const getTagSize = (count: number) => {
  const minSize = 1
  const maxSize = 2
  const minCount = Math.min(...tags.value.map((t) => t.count))
  const maxCount = Math.max(...tags.value.map((t) => t.count))

  if (maxCount === minCount) return `${maxSize}rem`

  const size = minSize + ((count - minCount) * (maxSize - minSize)) / (maxCount - minCount)
  return `${size}rem`
}
</script>

<style scoped>
.tags {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.tag-cloud {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  margin-top: 2rem;
}

.tag-item {
  text-decoration: none;
  color: #333;
  padding: 0.5rem 1rem;
  background-color: #f0f0f0;
  border-radius: 1rem;
  transition: all 0.2s;
}

.tag-item:hover {
  background-color: #007bff;
  color: white;
}
</style>
