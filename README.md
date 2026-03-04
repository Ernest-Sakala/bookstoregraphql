---

````markdown
# BookstoreGraphQL

![Java](https://img.shields.io/badge/Java-21-blue) 
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen) 
![License](https://img.shields.io/badge/License-MIT-lightgrey)

**BookstoreGraphQL** is a modern **online bookstore backend** built with **Spring Boot** and **GraphQL**, designed for browsing, searching, uploading, and downloading books efficiently.

---

## 📚 Features

- Browse and search books using **GraphQL queries**
- Upload books with: title, author, category, cover image, and file
- Download books directly from the platform
- Store book data in **PostgreSQL** with **Spring Data JPA**
- Manage database schema with **Liquibase**
- Fully tested with Spring Boot Test

---

## 💻 Tech Stack

- **Backend:** Spring Boot 3, Spring Data JPA, Spring GraphQL  
- **Database:** PostgreSQL  
- **Build & Dependency Management:** Maven  
- **Java Version:** 21  

---

## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven
- PostgreSQL

### Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Ernest-Sakala/bookstoregraphql.git
   cd bookstoregraphql
````

2. Configure your database in  `application.yml`
3. Build the project:

   ```bash
   mvn clean install
   ```
4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

---

## 🎯 GraphQL Usage Examples

### Query: Get All Books

```graphql
query {
  books {
    id
    title
    author
    category
  }
}
```

### Mutation: Upload a Book

```graphql
mutation {
  uploadBook(input: {
    title: "GraphQL in Action",
    author: "John Doe",
    category: "Technical",
    fileUrl: "books/graphql.pdf",
    imageUrl: "images/graphql.jpg"
  }) {
    id
    title
  }
}
```

### Query: Get Book by ID

```graphql
query {
  book(id: 1) {
    title
    author
    category
  }
}
```

---

## 🖼 Screenshots

<!-- <div align="center">
  <img src="screenshots/homepage.png" alt="Homepage" width="400"/>
  <img src="screenshots/upload-book.png" alt="Upload Book" width="400"/>
</div> -->

---

## 🤝 Contributing

Contributions are welcome! Please fork the repository and create a pull request.
Make sure your code is tested and follows the existing project structure.

---

## ⚖ License

This project is licensed under the **MIT License**.

```

---


