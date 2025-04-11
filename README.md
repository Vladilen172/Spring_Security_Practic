# 🌐 Регистрация и Авторизация с Spring Security

Простое веб-приложение на Spring Boot, реализующее регистрацию и авторизацию пользователей через **сессии** с использованием **Spring Security**.

## 📦 Стек технологий

- Java 23
- Spring Boot 3
- Spring Security
- Thymeleaf
- Maven
- HTML + Tailwind CSS (для стилей)

---

## 🚀 Возможности

- 📋 Регистрация нового пользователя
- 🔐 Авторизация через форму входа
- ✅ Валидация данных при регистрации
- 📄 Кастомные страницы входа, регистрации и приветствия
- 🚪 Выход из системы через кнопку (с завершением сессии)
- ⚠️ Глобальная обработка ошибок валидации
- 🛡 Без использования токенов или JWT (только сессии)
- 🛡 Используется кодирование паролей

---

## 📁 Структура проекта

.
├── config/ # Конфигурация безопасности
├── controllers/ # Контроллеры для логики входа, регистрации, домашней страницы
├── dto/ # DTO-объекты
├── exception/ # Глобальный обработчик ошибок
├── model/ # Сущность User
├── repository/ # Spring Data репозиторий
├── services/ # Бизнес-логика авторизации и регистрации
├── resources/
│   ├── templates/ # Шаблоны Thymeleaf (login, register, hello)
│   └── static/css/ # Стили CSS
└── SocialNetworkApplication.java

## ⚙️ Настройка

### 📦 Конфигурация базы данных
Чтобы не хранить чувствительные данные в репозитории (такие как логин и пароль к базе данных), приложение использует переменные среды (environment variables).

### 🛠 Настройка переменных
В файле src/main/resources/application.properties значения конфигурации подставляются из переменных среды:

   ```properties
   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   ```
### 🧪 Пример .env файла (не добавляется в Git)
Создайте .env в корне проекта для локальной разработки:

   ```ini
   DB_URL=jdbc:postgresql://localhost:5432/postgres
   DB_USERNAME=postgres
   DB_PASSWORD=your_password
   ```

## Запуск

1. **Склонируй репозиторий**:
   ```bash
   git clone https://github.com/Vladilen172/Spring_Security_Practic.git
   cd Spring_Security_Practic
   
2. Собери и запусти приложение:
    ``` bash
    ./mvnw spring-boot:run
    ```

3. Открой в браузере:

    ```bash
    http://localhost:8080/login
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

