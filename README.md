# 🚀 LogIn Maven Web Application

## 📌 Overview

This is a **Java Web Application** built using Servlets and JSP.
It implements a basic **authentication system** with:

* 🔐 User Signup
* 🔑 User Login
* 🔒 Password Hashing (BCrypt)
* 🗄️ Database Connectivity (MySQL using JDBC)

---

## 🛠️ Technologies Used

* Java (JDK 24)
* Maven (Web App Archetype)
* Jakarta Servlet API
* JSP (Java Server Pages)
* JDBC (Java Database Connectivity)
* MySQL Database

---

## 📦 Manually Included Libraries

The following libraries were **added manually (not via Maven initially)**:

* `jakarta.servlet-api-6.1.0`
* `jbcrypt-0.4`
* `mysql-connector-j-9.6.0`
* `junit-3.8.1` (via Maven)

---

## 📁 Project Structure

```
LogIn/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/javaFiles/
│       │       ├── LoginServlet.java
│       │       └── signupServlet.java
│       │
│       ├── resources/
│       │
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           │
│           ├── index.jsp
│           ├── login.jsp
│           └── signup.jsp
│
├── target/
├── .gitignore
├── pom.xml
└── README.md
```

---

# ⚙️ ⚡ Complete Setup Guide

## 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/WebTech.git
cd WebTech
```

---

## 2️⃣ Open Project in IntelliJ IDEA

* Open IntelliJ
* Click **Open**
* Select the project folder
* Wait for Maven to load dependencies

---

## 3️⃣ Configure JDK

* Go to: `File → Project Structure → Project`
* Set **Project SDK = JDK 24**

---

## 4️⃣ Configure Apache Tomcat (IMPORTANT)

You must use:
👉 Apache Tomcat **10+** (because of Jakarta Servlet)

### Steps:

* Go to: `Run → Edit Configurations`
* Click `+` → **Tomcat Server → Local**
* Set:

  * Tomcat Home Directory
  * Deployment → Add Artifact → `LogIn:war exploded`

---

## 5️⃣ Setup MySQL Database

### Create Database:

```sql
CREATE DATABASE login_db;
```

### Example Table:

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(255)
);
```

---

## 6️⃣ Configure Database in Code

Open your servlet and update:

```java
String url = "jdbc:mysql://localhost:3306/login_db";
String user = "root";
String password = "your_password";
```

---

## 7️⃣ Add Required Libraries (If Not Using Maven)

If dependencies are missing, ensure:

* `jakarta.servlet-api-6.1.0`
* `mysql-connector-j`
* `jbcrypt-0.4`

---

## 8️⃣ Run the Project

* Click **Run (Tomcat)**
* Open browser:

```
http://localhost:8080/LogIn/
```

---

## 🧪 Features

* ✅ User Registration (Signup)
* ✅ User Login Authentication
* ✅ Password Encryption using BCrypt
* ✅ MySQL Database Integration

---

## ⚠️ Important Notes

* Use **Tomcat 10+ only**
* Do NOT push:

  * `.idea/`
  * `.smarttomcat/`
* Prefer Maven dependencies over manual JARs

---

## 📈 Future Improvements

* 🔄 Convert to Spring Boot
* 🧠 Use Hibernate (ORM)
* 🔐 Add session management
* 🎨 Improve frontend UI
* ☁️ Deploy online

---

## 👨‍💻 Author

**Ahmad Salman**

---

## ⭐ Contribute

Feel free to fork and improve this project!
