<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const searchQuery = ref('')

const handleSearch = () => {
  if (searchQuery.value.trim()) {
    router.push({ path: '/search', query: { q: searchQuery.value } })
  }
}
</script>

<template>
  <div class="app">
    <header class="header">
      <div class="header-content">
        <div class="logo">
          <router-link to="/" class="logo-link">Jxun-h</router-link>
        </div>
        <nav class="nav">
          <router-link to="/" class="nav-item">
            <span>Home</span>
          </router-link>
          <router-link to="/about" class="nav-item">
            <span>About</span>
          </router-link>
          <router-link to="/archive" class="nav-item">
            <span>Archive</span>
          </router-link>
          <router-link to="/tags" class="nav-item">
            <span>Tags</span>
          </router-link>
          <div class="search-container">
            <input
              type="text"
              v-model="searchQuery"
              placeholder="Search..."
              @keyup.enter="handleSearch"
            />
          </div>
        </nav>
      </div>
    </header>
    <main class="main-content">
      <router-view></router-view>
    </main>
    <footer class="footer">
      <div class="footer-content">
        <div class="footer-section">
          <h3>About</h3>
          <p>개발과 관련된 다양한 주제를 공유하는 블로그입니다.</p>
        </div>
        <div class="footer-section">
          <h3>Links</h3>
          <div class="footer-links">
            <a href="https://github.com/Jxun-h" target="_blank">GitHub</a>
            <a href="#" target="_blank">LinkedIn</a>
            <a href="#" target="_blank">Twitter</a>
          </div>
        </div>
        <div class="footer-section">
          <h3>Contact</h3>
          <p>Email: example@example.com</p>
        </div>
      </div>
      <div class="footer-bottom">
        <p>© 2024 Jxun-h Blog. All rights reserved.</p>
      </div>
    </footer>
  </div>
</template>

<style scoped>
.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  background-color: #f8f9fa;
}

.header {
  background-color: white;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.header-content {
  max-width: 1584px;
  margin: 0 auto;
  padding: 0.75rem 1.5rem;
  display: flex;
  align-items: center;
}

.logo {
  font-size: 1.2rem;
  font-weight: bold;
  margin-right: 2rem;
}

.logo-link {
  text-decoration: none;
  color: #0096ff;
  line-height: 1.3;
}

.nav {
  display: flex;
  align-items: center;
  gap: 1.5rem;
  flex: 1;
}

.nav-item {
  text-decoration: none;
  color: #666;
  font-size: 0.9rem;
  transition: all 0.2s ease;
}

.nav-item:hover {
  color: #0096ff;
}

.search-container {
  margin-left: auto;
}

.search-container input {
  border: 1px solid #eee;
  background-color: #f8f9fa;
  padding: 0.4rem 0.7rem;
  border-radius: 15px;
  font-size: 0.85rem;
  width: 150px;
  outline: none;
}

.search-container input:focus {
  border-color: #0096ff;
}

.main-content {
  flex: 1;
  max-width: 1584px;
  margin: 0 auto;
  width: 100%;
  padding: 0 1.5rem;
}

.footer {
  background-color: #2c3e50;
  color: white;
  padding: 2rem 0 1rem;
  margin-top: 3rem;
}

.footer-content {
  max-width: 1584px;
  margin: 0 auto;
  padding: 0 1.5rem;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2rem;
}

.footer-section h3 {
  margin-bottom: 1rem;
  font-size: 1.1rem;
}

.footer-links {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.footer-links a {
  color: #ecf0f1;
  text-decoration: none;
  transition: color 0.3s ease;
}

.footer-links a:hover {
  color: #3498db;
}

.footer-bottom {
  text-align: center;
  margin-top: 2rem;
  padding-top: 1rem;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
}

@media (max-width: 768px) {
  .header-content {
    flex-direction: column;
    gap: 1rem;
  }

  .nav {
    flex-wrap: wrap;
    justify-content: center;
  }

  .search-container {
    margin-left: 0;
    width: 100%;
    margin-top: 0.5rem;
  }

  .search-container input {
    width: 100%;
  }

  .footer-content {
    grid-template-columns: 1fr;
  }
}
</style>
