<template>
  <div class="page-container">
    <!-- 프로필 섹션 -->
    <section class="profile-section section-card">
      <div class="profile-content">
        <h1 class="section-title">About</h1>
        <div class="profile-description">
          <p class="headline">
            안정적인 서비스 개발을 추구하는 <strong>Backend Developer 조형준</strong>입니다.
          </p>
        </div>
      </div>
    </section>

    <!-- 소개 섹션 -->
    <section class="intro-section section-card">
      <h2 class="section-title">Introduction</h2>
      <div class="intro-content">
        <p>트레이드 오프를 고려해 균형잡힌 선택을 하려 노력합니다.</p>
        <p>안정적인 서비스를 만드는데 기여하고자 노력하는 백엔드 개발자입니다.</p>
        <p>또한 서비스가 안정적으로 운영되기 위한 방법에 대해 고민합니다.</p>
      </div>
    </section>

    <!-- 블로그 작성 이유 섹션 -->
    <section class="blog-reason-section section-card">
      <h2 class="section-title">Why Post in Blog</h2>
      <div class="blog-reason-content">
        <p>블로그를 처음 쓰기 시작한 것은 2021년 08월 28일 입니다.</p>
        <p>
          코딩 테스트를 위해 고민했던 내용과 해결 과정들을 오로지 머리로만 기억하는 것에 한계가
          있음을 느꼈습니다.
        </p>
        <p>블로그를 제 두뇌의 외장하드로 쓰기 결심하고, 티스토리에서 포스팅을 시작했습니다.</p>
        <p>
          그 후 약 1년간 꾸준히 알고리즘 풀이를 포스팅 했고, 2023년 4월 18일 이후 공백기간이
          있었습니다.
        </p>
        <p>
          2024년을 맞이해 블로그 작성을 통해 쌓여가는 경험과 지식을 되돌아보고 회고록도 써보려고
          합니다.
        </p>
        <p>다시 시작하는 저의 블로그는 github.io 로 시작해보려 합니다.</p>
      </div>
    </section>

    <!-- 기술 스택 섹션 -->
    <section class="skills-section section-card">
      <h2 class="section-title">기술 스택</h2>
      <div class="skills-container">
        <div class="skill-category">
          <h3 class="skill-category-title">프론트엔드</h3>
          <div class="skill-list">
            <span class="skill-tag frontend">Vue.js</span>
            <span class="skill-tag frontend">TypeScript</span>
            <span class="skill-tag frontend">HTML/CSS</span>
          </div>
        </div>

        <div class="skill-category">
          <h3 class="skill-category-title">백엔드</h3>
          <div class="skill-list">
            <span class="skill-tag backend">Spring Boot</span>
            <span class="skill-tag backend">Java</span>
            <span class="skill-tag backend">MySQL</span>
          </div>
        </div>

        <div class="skill-category">
          <h3 class="skill-category-title">기타</h3>
          <div class="skill-list">
            <span class="skill-tag devops">Docker</span>
            <span class="skill-tag devops">Git</span>
            <span class="skill-tag cloud">AWS</span>
          </div>
        </div>
      </div>
    </section>

    <!-- 연락처 섹션 -->
    <section class="contact-section section-card">
      <h2 class="section-title">Contact</h2>
      <div class="grid-container col-3">
        <div class="contact-item item-card">
          <div class="contact-icon">📧</div>
          <div class="contact-info">
            <h3 class="contact-label">Email</h3>
            <a href="mailto:its1108@kakao.com" class="contact-value">its1108@kakao.com</a>
          </div>
        </div>

        <div class="contact-item item-card">
          <div class="contact-icon">🐙</div>
          <div class="contact-info">
            <h3 class="contact-label">GitHub</h3>
            <a href="https://github.com/Jxun-h" target="_blank" class="contact-value"
              >github.com/Jxun-h</a
            >
          </div>
        </div>

        <div class="contact-item item-card">
          <div class="contact-icon">📝</div>
          <div class="contact-info">
            <h3 class="contact-label">Tistory</h3>
            <a href="https://dreamtreeits.tistory.com" target="_blank" class="contact-value"
              >dreamtreeits.tistory.com</a
            >
          </div>
        </div>
      </div>
    </section>

    <!-- 이력서 섹션 -->
    <section class="resume-section section-card">
      <h2 class="section-title">Resume</h2>
      <div class="resume-content">
        <p>이력과 포트폴리오를 기재한 이력서입니다.</p>
        <div class="resume-button-container">
          <router-link to="/resume" class="resume-button">이력서 보기</router-link>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup lang="ts">
// 필요한 경우 추가 스크립트
</script>

<style scoped>
.profile-section {
  margin-top: 2rem;
  padding: 2.5rem;
}

.profile-content {
  width: 100%;
}

.profile-description {
  line-height: 1.7;
  color: var(--text-color);
  font-size: 1.1rem;
  margin-top: 1rem;
}

.headline {
  font-size: 1.5rem;
  font-weight: 500;
  line-height: 1.6;
}

.profile-description p {
  margin-bottom: 0.8rem;
}

/* 소개 섹션 및 블로그 이유 섹션 */
.intro-content,
.blog-reason-content {
  line-height: 2;
  color: var(--secondary-color);
  font-size: 1.05rem;
  max-width: 800px;
  margin: 0 auto;
}

.intro-content p,
.blog-reason-content p {
  margin-bottom: 1.2rem;
  text-align: justify;
}

.intro-content p:first-child,
.blog-reason-content p:first-child {
  font-weight: 500;
  color: var(--text-color);
}

/* 기술 스택 스타일 */
.skills-container {
  display: flex;
  justify-content: space-between;
  gap: 1.5rem;
  margin-top: 1rem;
}

.skill-category {
  flex: 1;
  background-color: var(--card-background);
  border-radius: var(--item-card-radius);
  border: 1px solid var(--border-color);
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  min-height: 250px;
}

.skill-category-title {
  color: var(--text-color);
  font-size: 1.2rem;
  text-align: center;
  margin-bottom: 1.5rem;
  position: relative;
  padding-bottom: 0.8rem;
  font-weight: 600;
}

.skill-category-title::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  width: 50px;
  height: 2px;
  background-color: var(--primary-color);
}

.skill-list {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  align-items: center;
  flex: 1;
  justify-content: center;
}

.skill-tag {
  padding: 0.6rem 1.5rem;
  border-radius: 30px;
  color: white;
  font-weight: 500;
  font-size: 0.95rem;
  text-align: center;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s ease;
  width: 100%;
  max-width: 180px;
}

.skill-tag:hover {
  transform: translateY(-2px);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
}

.skill-tag.frontend {
  background-color: #42b883;
}

.skill-tag.backend {
  background-color: #4986e7;
}

.skill-tag.devops {
  background-color: #f57c00;
}

.skill-tag.cloud {
  background-color: #9c27b0;
}

/* 연락처 스타일 */
.contact-item {
  display: flex;
  align-items: center;
  gap: 1.2rem;
  height: 100%;
  padding: 0.5rem;
}

.contact-icon {
  font-size: 1.6rem;
  background-color: var(--search-background);
  width: 50px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  flex-shrink: 0;
  box-shadow: 0 3px 8px rgba(0, 0, 0, 0.08);
}

.contact-info {
  flex: 1;
}

.contact-label {
  font-size: 0.95rem;
  color: var(--secondary-color);
  margin-bottom: 0.4rem;
}

.contact-value {
  font-size: 1.05rem;
  color: var(--primary-color);
  text-decoration: none;
  font-weight: 500;
  transition: color 0.2s ease;
}

.contact-value:hover {
  color: var(--link-hover-color);
  text-decoration: underline;
}

/* 이력서 버튼 */
.resume-content {
  text-align: center;
  color: var(--secondary-color);
  line-height: 1.8;
  max-width: 700px;
  margin: 0 auto;
}

.resume-button-container {
  margin-top: 1.5rem;
}

.resume-button {
  display: inline-block;
  background-color: var(--primary-color);
  color: white;
  padding: 0.8rem 1.5rem;
  border-radius: 30px;
  font-weight: 500;
  transition: all 0.3s ease;
  text-decoration: none;
}

.resume-button:hover {
  background-color: var(--link-hover-color);
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
  color: white;
}

/* 반응형 스타일 */
@media (max-width: 768px) {
  .skills-container {
    flex-direction: column;
  }

  .skill-category {
    min-height: auto;
    padding: 1.2rem;
  }
}

/* 섹션 스타일 강화 */
.section-card {
  max-width: 1200px;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 2.5rem;
}
</style>
