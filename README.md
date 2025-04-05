# Blog Project

개발 블로그 프로젝트입니다. Vue 3, Spring Boot, MySQL, Docker를 사용하여 구현했습니다.

## 🚀 기술 스택

### Frontend

- Vue 3
- TypeScript
- Pinia (상태 관리)
- Vue Router
- Axios

### Backend

- Spring Boot 3.2.3
- Spring Data JPA
- Spring Security
- MySQL 8.0
- Gradle

### DevOps

- Docker
- Docker Compose

## 📋 주요 기능

- 블로그 포스트 작성 및 관리
- 태그 기반 포스트 분류
- 포스트 검색 기능
- 아카이브 기능
- 반응형 디자인

## 🛠️ 개발 환경 설정

### 필수 요구사항

- Docker
- Docker Compose
- Node.js 18+
- Java 17+

### 설치 및 실행

1. 저장소 클론

```bash
git clone https://github.com/Jxun-h/blog-project.git
cd blog-project
```

2. Docker 컨테이너 실행

```bash
docker-compose up --build
```

3. 서비스 접속

- 프론트엔드: http://localhost:28080
- 백엔드: http://localhost:28081
- MySQL: localhost:23306

## 📁 프로젝트 구조

```
blog-project/
├── frontend/           # Vue 3 프론트엔드
│   └── vue-project/
├── backend/            # Spring Boot 백엔드
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   └── build.gradle
├── docker-compose.yml  # Docker 설정
└── README.md
```

## 🔧 API 문서

### 포스트 관련 API

#### 포스트 목록 조회

```
GET /api/posts
```

#### 포스트 상세 조회

```
GET /api/posts/{id}
```

#### 포스트 검색

```
GET /api/posts/search?keyword={keyword}
```

#### 태그별 포스트 조회

```
GET /api/posts/tags?tags={tag1,tag2}
```

#### 포스트 작성

```
POST /api/posts
```

#### 포스트 수정

```
PUT /api/posts/{id}
```

#### 포스트 삭제

```
DELETE /api/posts/{id}
```

## 🤝 기여하기

1. 이슈 생성
2. 브랜치 생성 (`git checkout -b feature/기능명`)
3. 변경사항 커밋 (`git commit -m 'Add some feature'`)
4. 브랜치 푸시 (`git push origin feature/기능명`)
5. Pull Request 생성

## 📝 라이센스

이 프로젝트는 MIT 라이센스를 따릅니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.

## 📞 문의

문제가 있거나 문의사항이 있으시면 이슈를 생성해 주세요.
