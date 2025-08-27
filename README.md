# 📧 AI-Powered Email Assistant  

[![Java](https://img.shields.io/badge/Java-17-red?logo=java&logoColor=white)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/SpringBoot-3-green?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)  
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)  
[![Build](https://img.shields.io/badge/Build-Maven-lightgrey?logo=apachemaven)](https://maven.apache.org/)  

An intelligent **Email Assistant** built with **Spring Boot** and **Gemini API**, designed to help users **compose, summarize, and manage emails effortlessly**.  
This project demonstrates integration of **AI into backend workflows**, showcasing real-world applications of LLMs in productivity tools.  

---

## ✨ Features  

- 🤖 **AI Email Drafting** – Generates professional email responses instantly.  
- 📝 **Summarization** – Condenses lengthy emails into quick, digestible summaries.  
- 🎯 **Smart Suggestions** – Provides tone-adjusted replies (formal, casual, persuasive, etc.).  
- 🔒 **Secure Backend** – Built with **Spring Boot**, **JWT authentication**, and scalable APIs.  
- ⚡ **Real-time Integration** – Optimized for frontend apps (React, Angular, etc.) via REST endpoints.  

---

## 🛠️ Tech Stack  

| **Category** | **Technologies Used** |
|--------------|------------------------|
| Backend | Spring Boot, Java |
| AI | Gemini API (Google’s LLM) |
| Security | JWT Authentication |
| API Handling | REST |
| Build Tools | Maven |
| Deployment | Docker, GitHub Actions (optional) |

---

## 📂 Project Structure  
email-assistant/
│── src/main/java/com/ashton/emailassistant/
│ ├── controller/ # API controllers
│ ├── service/ # Business logic + Gemini API integration
│ ├── entity/ # Models
│ ├── config/ # Security/JWT setup
│── src/main/resources/
│ ├── application.yml # Configurations
│── README.md
