# 🛡️ CyberLog Analyzer
### Java-Based Security Log Monitoring & Analysis System

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Gradle](https://img.shields.io/badge/Gradle-9.2.1-02303A?style=for-the-badge&logo=gradle)
![HTML](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

**CyberLog Analyzer** is a Java-based security log monitoring and analysis application designed to identify suspicious login activities and detect potentially malicious IP addresses.

The application processes security log files, analyzes authentication events, and presents meaningful security insights through an interactive web dashboard.

---

## 📌 Project Overview

Security logs contain valuable information about system activities, authentication attempts, and potential security threats.

CyberLog Analyzer simplifies this process by automatically analyzing log records and highlighting suspicious login patterns.

It provides a simple and user-friendly dashboard where users can upload security log files and view analysis results.

## ✨ Key Features

- **Security Log Analysis:** Upload and analyze `.log` files.
- **Login Activity Monitoring:** Count successful and failed login attempts.
- **Suspicious IP Detection:** Identify IP addresses with three or more failed login attempts.
- **Interactive Dashboard:** Display security statistics in a clean dashboard.
- **Activity Visualization:** View successful and failed login distribution.
- **Automated Analysis:** Process uploaded logs using Java backend logic.
- **Unit Testing:** Validate core log analysis methods using JUnit 5.

## 🖥️ Dashboard

The application provides an interactive dashboard containing:

| Component | Description |
|---|---|
| Total Log Entries | Displays the total number of analyzed records |
| Successful Logins | Shows successful authentication attempts |
| Failed Logins | Displays failed authentication attempts |
| Login Activity | Visualizes login activity distribution |
| Suspicious IP Monitoring | Highlights IP addresses with repeated failed attempts |

## ⚙️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend development and log processing |
| Gradle 9.2.1 | Build automation and dependency management |
| HTML5 | Dashboard structure |
| CSS3 | Dashboard styling and responsive layout |
| JavaScript | Frontend interaction and API communication |
| JUnit 5 | Unit testing |
| Docker | Optional containerization and deployment |

## 🏗️ Project Architecture

```text
CyberLog-Analyzer/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/codealpha/cyberlog/app/
│   │   │   │       ├── App.java
│   │   │   │       ├── LogServer.java
│   │   │   │       └── LogAnalyzer.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── web/
│   │   │           └── index.html
│   │   │
│   │   └── test/
│   │
│   └── build.gradle
│
├── list/
├── utilities/
├── build-logic/
├── gradle/
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

## 🔄 Application Workflow

1. User opens the CyberLog Analyzer dashboard.
2. A security log file is uploaded through the interface.
3. JavaScript sends the log data to the Java backend.
4. The backend processes the log records.
5. Successful and failed login attempts are counted.
6. Suspicious IP addresses are identified.
7. The analysis results are displayed on the dashboard.

## 🚀 Getting Started

### Prerequisites

Make sure the following tools are installed:

- Java Development Kit (JDK) 21
- Gradle 9.2.1 or compatible Gradle Wrapper
- Git
- Web Browser

### Installation

**1. Clone the repository**

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

**2. Navigate to the project directory**

```bash
cd CodeAlpha_Java_Gradle
```

**3. Build the project**

Windows:

```bash
gradlew.bat build
```

**4. Run the application**

```bash
gradlew.bat :app:run
```

**5. Open the dashboard**

Visit the following address in your browser:

```text
http://localhost:8080
```

## 🧪 Testing

The project uses JUnit 5 to test the core log analysis functionality.

Run the test suite using:

```bash
gradlew.bat :app:test
```

The tests cover:

- Counting failed login attempts.
- Counting successful login attempts.
- Identifying failed attempts associated with IP addresses.

## 📄 Sample Log Format

The application supports security log records in the following format:

```text
192.168.1.10 LOGIN_SUCCESS user=gauri
192.168.1.20 LOGIN_FAILED user=admin
192.168.1.20 LOGIN_FAILED user=root
192.168.1.30 LOGIN_SUCCESS user=tanvi
192.168.1.40 LOGIN_FAILED user=guest
```

## 📊 Sample Analysis Output

```text
===== CYBERLOG SECURITY REPORT =====

Total Logs: 10
Successful Logins: 3
Failed Logins: 7

===== SUSPICIOUS IP ADDRESSES =====

192.168.1.20 - 4 Failed Attempts
192.168.1.40 - 3 Failed Attempts

Analysis Completed!
```

*Sample output is based on the project's sample security log file.*

## 🔐 Security Note

CyberLog Analyzer is an educational log analysis project. Its suspicious IP detection is based on predefined rules and should not be considered a complete enterprise-grade intrusion detection system.

## 🎯 Project Objective

The objective of this project is to demonstrate practical implementation of Java application development, Gradle build automation, backend processing, unit testing, and basic security log monitoring.

## 👩‍💻 Author

**Gauri Somwanshi**

B.Sc. Cyber Security Student  
Aspiring Security Analyst | Cybersecurity Enthusiast

## 🏢 Internship

Developed as part of the **CodeAlpha DevOps Internship Program**.

---

⭐ If you find this project interesting, consider giving this repository a star!

**Built with ❤️ by Gauri Somwanshi**
