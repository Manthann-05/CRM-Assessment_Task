# CRM REST API (Spring Boot)

## 📌 Project Overview

This project is a **basic Customer Relationship Management (CRM) REST API** built using **Spring Boot**. It demonstrates backend development best practices by implementing a clean, scalable, and layered architecture for managing customers and sales leads.

The API allows users to perform full **CRUD operations on customer records**, along with additional features such as pagination, searching, and lead management linked to customers.

---

## 🎯 Problem Statement

Design and implement a RESTful API for an open-source CRM system that enables efficient management of customer data and sales leads.

---

## 🚀 Features

### 👤 Customer Management
- Create a new customer record
- Retrieve customer details by ID
- Update existing customer information
- Delete customer records

### 📄 Customer Listing
- Retrieve all customers with **pagination support**

### 🔍 Search Functionality
- Search customers by **name or email (case-insensitive)**

### 📊 Sales Lead Management (Bonus Feature)
- Create leads linked to customers
- Retrieve all leads
- Delete leads

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- RESTful APIs

---

## 🏗️ Architecture

This project follows a **layered architecture**:

- Controller Layer → Handles API requests
- Service Layer → Business logic implementation
- Repository Layer → Database interaction
- DTO Layer → Data transfer between layers
- Entity Layer → Database models
- Exception Handling → Global error management

---

## 📌 API Functionalities

### Customer APIs
- `POST /api/customers` → Create customer  
- `GET /api/customers/{id}` → Get customer by ID  
- `GET /api/customers` → Get all customers (paginated)  
- `GET /api/customers/search?keyword=` → Search customers  
- `PUT /api/customers/{id}` → Update customer  
- `DELETE /api/customers/{id}` → Delete customer  

### Lead APIs
- `POST /api/leads` → Create lead  
- `GET /api/leads` → Get all leads  
- `DELETE /api/leads/{id}` → Delete lead  

---

## 👨‍💻 Author

Developed as a full stack backend engineering assessment project using Spring Boot.
