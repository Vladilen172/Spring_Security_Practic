# 🌐 Регистрация и Авторизация с Spring Security

Простое веб-приложение на Spring Boot, реализующее регистрацию и авторизацию пользователей через **сессии** с использованием **Spring Security**.

---

## 📦 Стек технологий

- Java 23
- Spring Boot 3
- Spring Security
- PostgreSQL (через Docker)
- Docker + Docker Compose
- Thymeleaf
- Maven
- HTML + Tailwind CSS

---

## 🚀 Возможности

- 📋 Регистрация нового пользователя
- 🔐 Авторизация через форму входа
- ✅ Валидация данных при регистрации
- 📄 Кастомные страницы входа, регистрации и приветствия
- 🚪 Выход из системы через кнопку (с завершением сессии)
- ⚠️ Глобальная обработка ошибок валидации
- 🛡 Без использования токенов или JWT (только сессии)
- 🔐 Используется кодирование паролей (BCrypt)
- 🐳  Запуск приложения и базы данных через Docker Compose

---


## 📁 Структура проекта
```
.
├── docker-compose.yml             # Файл для запуска контейнеров с приложением и БД
├── mvnw, mvnw.cmd                 # Скрипты для запуска Maven Wrapper (кроссплатформенные)
├── pom.xml                        # Maven-файл с зависимостями и конфигурациями проекта
├── README.md                      # Документация проекта
└── src
    ├── main
    │   ├── java
    │   │   └── com.example.social_network
    │   │       ├── config
    │   │       │   └── SecurityConfig.java         # Настройки Spring Security
    │   │       ├── controllers
    │   │       │   ├── AuthController.java         # Обработка входа в систему
    │   │       │   ├── HomeController.java         # Контроллер для главной страницы
    │   │       │   └── RegistrationController.java # Обработка регистрации
    │   │       ├── dto
    │   │       │   ├── RegistrationRequest.java    # DTO для регистрации
    │   │       │   └── UserPrincipal.java          # Объект безопасности пользователя
    │   │       ├── exception
    │   │       │   └── GlobalExceptionHandler.java # Глобальный обработчик ошибок
    │   │       ├── model
    │   │       │   └── User.java                   # Сущность пользователя
    │   │       ├── repository
    │   │       │   └── UserRepository.java         # Репозиторий для работы с User
    │   │       ├── services
    │   │       │   ├── MyUserDetailsService.java   # Логика загрузки пользователя
    │   │       │   └── RegistrationService.java    # Логика регистрации
    │   │       └── SocialNetworkApplication.java   # Точка входа в Spring Boot приложение
    │   └── resources
    │       ├── application.properties              # Конфигурация приложения
    │       ├── static
    │       │   ├── css
    │       │   │   ├── login.css                   # Стили для страницы входа
    │       │   │   └── register.css                # Стили для страницы регистрации
    │       │   └── screenshots
    │       │       ├── authorization.png           # Скриншот страницы входа
    │       │       ├── home.png                    # Скриншот главной страницы
    │       │       └── register.png                # Скриншот страницы регистрации
    │       └── templates
    │           ├── hello.html                      # Шаблон приветственной страницы
    │           ├── login.html                      # Шаблон страницы входа
    │           └── register.html                   # Шаблон страницы регистрации
    └── test
        └── java
            └── com.example.social_network
                └── SocialNetworkApplicationTests.java # Тест для запуска контекста приложения
```

## 🐳 Запуск в Docker-контейнере
Проект готов к запуску в контейнере с использованием docker-compose. Все нужные сервисы (приложение + база данных) стартуют автоматически.

### 📁 Структура
Файл docker-compose.yml уже находится в корне проекта.

```
Spring_Security_Practic/
├── docker-compose.yml
├── Dockerfile
├── ...
```

### ⚙️ Состав docker-compose

```yaml
version: '3.8'

services:
  db:
    image: postgres:17
    container_name: social_db
    environment:
      POSTGRES_DB: social
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  app:
    build: .
    container_name: social_app
    ports:
      - "8080:8080"
    environment:
      DB_URL: jdbc:postgresql://db:5432/social
      DB_USERNAME: postgres
      DB_PASSWORD: postgres
    depends_on:
      - db

volumes:
  postgres_data:
```

### 🐳 Dockerfile
```Dockerfile
FROM openjdk:23-ea-slim
COPY . /app
WORKDIR /app
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/social_network-0.0.1-SNAPSHOT.jar"]
```

### ▶️ Как запустить
1. Перейди в корень проекта:

```bash
  cd Spring_Security_Practic
```

2. Построй и запусти контейнеры:

```bash
   docker-compose up --build
```

3. Откройте браузер

```bash
  http://localhost:8080/login
```

### 🛑 Остановка контейнеров

```bash
   docker-compose down
```

## 🔑 Доступ
### 📄 Регистрация
Открой /register и создай нового пользователя. После успешной регистрации будет доступна авторизация.

## 🔐 Авторизация
Вход через /login. 
После входа пользователь будет перенаправлен на страницу приветствия /hello.

## 📸 Скриншоты

| Страница входа                                                                                      |
|-----------------------------------------------------------------------------------------------------|
| <img src="./src/main/resources/static/screenshots/authorization.png" alt="Login Page" width="600"/> |

<br>

| Страница регистрации                                                                              |
|---------------------------------------------------------------------------------------------------|
| <img src="./src/main/resources/static/screenshots/register.png" alt="Register Page" width="600"/> |

<br>

| Приветствие                                                                               |
|-------------------------------------------------------------------------------------------|
| <img src="./src/main/resources/static/screenshots/home.png" alt="Home Page" width="600"/> |

