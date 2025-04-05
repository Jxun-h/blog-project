<template>
  <div class="about">
    <section class="profile">
      <div class="profile-image">
        <img src="https://via.placeholder.com/200" alt="Profile" />
      </div>
      <div class="profile-content">
        <h1>About Me</h1>
        <p class="profile-description">
          안녕하세요! 저는 개발 블로그를 운영하는 개발자입니다. 이 블로그에서는 개발 관련 다양한
          주제를 포스팅하고 있습니다.
        </p>
      </div>
    </section>

    <section class="skills">
      <h2>기술 스택</h2>
      <div class="skills-grid">
        <div class="skill-category">
          <h3>프론트엔드</h3>
          <div class="skill-tags">
            <span class="skill-tag">Vue.js</span>
            <span class="skill-tag">TypeScript</span>
            <span class="skill-tag">HTML/CSS</span>
          </div>
        </div>
        <div class="skill-category">
          <h3>백엔드</h3>
          <div class="skill-tags">
            <span class="skill-tag">Spring Boot</span>
            <span class="skill-tag">Java</span>
            <span class="skill-tag">MySQL</span>
          </div>
        </div>
        <div class="skill-category">
          <h3>기타</h3>
          <div class="skill-tags">
            <span class="skill-tag">Docker</span>
            <span class="skill-tag">Git</span>
            <span class="skill-tag">AWS</span>
          </div>
        </div>
      </div>
    </section>

    <section class="contact">
      <h2>연락처</h2>
      <div class="contact-info">
        <div class="contact-item">
          <span class="contact-label">Email:</span>
          <a href="mailto:example@example.com" class="contact-link">example@example.com</a>
        </div>
        <div class="contact-item">
          <span class="contact-label">GitHub:</span>
          <a href="https://github.com/Jxun-h" target="_blank" class="contact-link"
            >github.com/Jxun-h</a
          >
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
// Component logic here
</script>

<style scoped>
.about {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
}

.profile {
  display: flex;
  align-items: center;
  gap: 3rem;
  margin-bottom: 4rem;
  background: white;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.profile-image img {
  width: 200px;
  height: 200px;
  border-radius: 50%;
  object-fit: cover;
}

.profile-content h1 {
  font-size: 2.5rem;
  margin-bottom: 1rem;
  color: #333;
}

.profile-description {
  font-size: 1.1rem;
  line-height: 1.6;
  color: #666;
}

.skills {
  margin-bottom: 4rem;
}

.skills h2 {
  text-align: center;
  margin-bottom: 2rem;
  font-size: 2rem;
  color: #333;
}

.skills-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
}

.skill-category {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.skill-category h3 {
  margin-bottom: 1rem;
  color: #333;
  font-size: 1.2rem;
}

.skill-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
}

.skill-tag {
  background: #f0f0f0;
  padding: 0.5rem 1rem;
  border-radius: 20px;
  font-size: 0.9rem;
  color: #666;
  transition: all 0.3s ease;
}

.skill-tag:hover {
  background: #007bff;
  color: white;
}

.contact {
  background: white;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.contact h2 {
  text-align: center;
  margin-bottom: 2rem;
  font-size: 2rem;
  color: #333;
}

.contact-info {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.contact-item {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.contact-label {
  font-weight: bold;
  color: #333;
  min-width: 80px;
}

.contact-link {
  color: #007bff;
  text-decoration: none;
  transition: color 0.3s ease;
}

.contact-link:hover {
  color: #0056b3;
}

@media (max-width: 768px) {
  .profile {
    flex-direction: column;
    text-align: center;
    gap: 2rem;
  }

  .profile-image img {
    width: 150px;
    height: 150px;
  }

  .skills-grid {
    grid-template-columns: 1fr;
  }
}
</style>
