<script setup lang="ts">
import { ref, onMounted, watch } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const searchQuery = ref('')
const isDarkMode = ref(false)

// 다크모드 토글 함수
const toggleDarkMode = () => {
  isDarkMode.value = !isDarkMode.value
  // 로컬 스토리지에 사용자 선호 저장
  localStorage.setItem('darkMode', isDarkMode.value ? 'true' : 'false')
  // HTML 요소에 다크모드 클래스 적용
  applyDarkMode()
}

// 다크모드 적용 함수
const applyDarkMode = () => {
  if (isDarkMode.value) {
    document.documentElement.classList.add('dark-mode')
  } else {
    document.documentElement.classList.remove('dark-mode')
  }
}

// 사용자 선호 설정 로드
onMounted(() => {
  const savedDarkMode = localStorage.getItem('darkMode')
  if (savedDarkMode) {
    isDarkMode.value = savedDarkMode === 'true'
    applyDarkMode()
  } else {
    // 시스템 설정 확인
    const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches
    isDarkMode.value = prefersDark
    applyDarkMode()
  }
})

// 검색 함수
const handleSearch = () => {
  if (searchQuery.value.trim()) {
    router.push({ path: '/search', query: { q: searchQuery.value } })
  }
}
</script>

<template>
  <div class="app" :class="{ 'dark-mode': isDarkMode }">
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
          <div class="search-container">
            <input
              type="text"
              v-model="searchQuery"
              placeholder="Search..."
              @keyup.enter="handleSearch"
            />
          </div>
          <button class="dark-mode-toggle" @click="toggleDarkMode">
            {{ isDarkMode ? '☀️' : '🌙' }}
          </button>
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

<style>
/* 다크모드 CSS 변수 */
:root {
  --background-color: #f8f9fa;
  --text-color: #333;
  --card-background: white;
  --header-background: white;
  --footer-background: #2c3e50;
  --footer-text: white;
  --border-color: #eee;
  --link-color: #0096ff;
  --link-hover-color: #007acc;
  --primary-color: #0096ff;
  --secondary-color: #666;
  --card-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
  --search-background: #f8f9fa;
  --search-border: #eee;
}

/* 다크모드 CSS 변수 */
.dark-mode {
  --background-color: #1a1a1a;
  --text-color: #f0f0f0;
  --card-background: #2d2d2d;
  --header-background: #2d2d2d;
  --footer-background: #1a1a1a;
  --footer-text: #f0f0f0;
  --border-color: #444;
  --link-color: #66b3ff;
  --link-hover-color: #99ccff;
  --primary-color: #66b3ff;
  --secondary-color: #aaa;
  --card-shadow: 0 1px 3px rgba(0, 0, 0, 0.4);
  --search-background: #333;
  --search-border: #444;
}

/* 글로벌 스타일 */
body {
  background-color: var(--background-color);
  color: var(--text-color);
  transition:
    background-color 0.3s ease,
    color 0.3s ease;
}

.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  background-color: var(--background-color);
}

.header {
  background-color: var(--header-background);
  box-shadow: var(--card-shadow);
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
  color: var(--primary-color);
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
  color: var(--secondary-color);
  font-size: 0.9rem;
  transition: all 0.2s ease;
}

.nav-item:hover {
  color: var(--primary-color);
}

.search-container {
  margin-left: auto;
}

.search-container input {
  border: 1px solid var(--search-border);
  background-color: var(--search-background);
  padding: 0.4rem 0.7rem;
  border-radius: 15px;
  font-size: 0.85rem;
  width: 150px;
  outline: none;
  color: var(--text-color);
}

.search-container input:focus {
  border-color: var(--primary-color);
}

/* 다크모드 토글 버튼 */
.dark-mode-toggle {
  background: none;
  border: none;
  font-size: 1.2rem;
  cursor: pointer;
  padding: 0.3rem;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background-color 0.3s ease;
}

.dark-mode-toggle:hover {
  background-color: var(--search-background);
}

.main-content {
  flex: 1;
  max-width: 1584px;
  margin: 0 auto;
  width: 100%;
  padding: 0 1.5rem;
}

.footer {
  background-color: var(--footer-background);
  color: var(--footer-text);
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
  color: var(--footer-text);
  text-decoration: none;
  transition: color 0.3s ease;
}

.footer-links a:hover {
  color: var(--primary-color);
}

.footer-bottom {
  text-align: center;
  margin-top: 2rem;
  padding-top: 1rem;
  border-top: 1px solid var(--border-color);
}

/* 반응형 디자인 */
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
