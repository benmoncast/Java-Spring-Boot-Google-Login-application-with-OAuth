# Google Login with Spring Boot, MySQL, and Thymeleaf

This is a full-featured Java Spring Boot application that implements **Google OAuth2 Login**, stores user credentials in a **MySQL database**, displays a custom dashboard using **Thymeleaf**, and includes a secure **Logout** functionality with a custom confirmation page.

---

## Features

- Google Sign-In with OAuth2
- User data (Name, Email, Picture) stored in MySQL
- Thymeleaf templates for Login, Dashboard, Logout confirmation
- Secure session-based authentication
- Logout with session invalidation and confirmation message
- Easy to run and customize

---

## Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Security (OAuth2 Client)
- MySQL
- Thymeleaf
- Maven

---

## Prerequisites

- JDK 17 or above
- Maven
- MySQL server
- Google Cloud account (for OAuth client credentials)

---

## Setup Instructions

# 1. Clone the Repository


git clone https://github.com/your-username/google-login-springboot.git
cd google-login-springboot


# 2. Create Google OAuth2 Credentials
Visit: https://console.cloud.google.com/

Create a new project.

Navigate to APIs & Services > Credentials.

Click Create Credentials > OAuth client ID.

Choose Web application.

Add the following authorized redirect URI: http://localhost:8080/login/oauth2/code/google
Copy the Client ID and Client Secret.

# 3. Configure application.properties

Server
server.port=8080

Google OAuth2
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=profile,email

MySQL Database
spring.datasource.url=jdbc:mysql://localhost:3306/google_login_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# 4. Set Up the MySQL Database

CREATE DATABASE google_login_db;
-- The application will auto-create the table based on the User entity:
-- Table: users (id, name, email, picture)

# 5. Build and Run the App
mvn clean install
mvn spring-boot:run
Application Endpoints

# Route	Description
/	Home Page (Public)
/login	Login Page (with Google button)
/dashboard	Dashboard (Authenticated)
/logout	POST request to log out the user
/logout-success	Custom logout confirmation page


# Project Structure

src
├── main
│   ├── java
│   │   └── benmoncast.com.googleLogin
│   │       ├── controller
│   │       │   └── AuthController.java
│   │       ├── config
│   │       │   └── SecurityConfig.java
│   │       ├── model
│   │       │   └── User.java
│   │       ├── repository
│   │       │   └── UserRepository.java
│   │       └── security
│   │           └── CustomOAuth2UserService.java
│   └── resources
│       ├── templates
│       │   ├── index.html
│       │   ├── login.html
│       │   ├── dashboard.html
│       │   └── logout.html
│       └── application.properties


#Screenshots
Dashboard Page
Displays user info from Google:
Logout Confirmation
## Screenshots

### Login Page

![Login Page](blob/main/src/main/screenshot/login.png)

### User Home Page

![User Home Page](/main/src/main/screenshot/login.png)

# Security
OAuth2 authentication handled by Spring Security
Session management with automatic invalidation on logout
No credentials stored in plaintext

# License
This project is licensed under the MIT License. See the LICENSE file for details.

#Author
Benedict Castro

GitHub: https://github.com/benmoncast

LinkedIn: Benedict Castro
