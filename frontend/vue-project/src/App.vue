<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
</script>

<template>
  <div class="app">
    <header class="header">
      <nav class="nav">
        <router-link to="/" class="nav-item">Home</router-link>
        <router-link to="/about" class="nav-item">About</router-link>
        <router-link to="/archive" class="nav-item">Archive</router-link>
        <router-link to="/tags" class="nav-item">Tags</router-link>
        <div class="search-container">
          <input type="text" v-model="searchQuery" placeholder="Search..." @keyup.enter="search" />
        </div>
      </nav>
    </header>
    <main class="main-content">
      <router-view></router-view>
    </main>
    <footer class="footer">
      <p>© 2024 My Blog. Powered by Vue 3 & Spring Boot</p>
    </footer>
  </div>
</template>

<style scoped>
.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.header {
  background-color: #f8f9fa;
  padding: 1rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.nav {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  gap: 2rem;
}

.nav-item {
  text-decoration: none;
  color: #333;
  font-weight: 500;
}

.nav-item:hover {
  color: #007bff;
}

.search-container {
  margin-left: auto;
}

.search-container input {
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.main-content {
  flex: 1;
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
}

.footer {
  background-color: #f8f9fa;
  padding: 1rem;
  text-align: center;
  margin-top: auto;
}
</style>
