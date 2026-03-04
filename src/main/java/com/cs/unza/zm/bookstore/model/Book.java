package com.cs.unza.zm.bookstore.model;


import jakarta.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String category;   // Technical, Self Improvement, etc.
    private String imageSlug;  // image filename
    private String filePath;

    public Book() {
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(String title, String author, String category, String imageSlug, String filePath) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.imageSlug = imageSlug;
        this.filePath = filePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
