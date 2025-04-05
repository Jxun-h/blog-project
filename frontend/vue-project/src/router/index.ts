import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import ArchiveView from '../views/ArchiveView.vue'
import TagsView from '../views/TagsView.vue'
import SearchView from '../views/SearchView.vue'
import PostView from '../views/PostView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView,
    },
    {
      path: '/archive',
      name: 'archive',
      component: ArchiveView,
    },
    {
      path: '/tags',
      name: 'tags',
      component: TagsView,
    },
    {
      path: '/search',
      name: 'search',
      component: SearchView,
    },
    {
      path: '/post/:id',
      name: 'post',
      component: PostView,
    },
  ],
})

export default router
