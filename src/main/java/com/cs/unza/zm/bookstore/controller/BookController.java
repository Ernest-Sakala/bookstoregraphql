package com.cs.unza.zm.bookstore.controller;

import com.cs.unza.zm.bookstore.model.Book;
import com.cs.unza.zm.bookstore.service.BookService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Book> books() {
        return service.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument Integer id) {
        return service.getBookById(id);
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author) {
        return service.createBook(title, author);
    }

    @MutationMapping
    public Book uploadBook(@Argument String title, @Argument String author, @Argument String category, @Argument MultipartFile image, @Argument MultipartFile file) throws IOException {
        return service.uploadBook(title, author, category, image, file);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Integer id) {
        service.deleteBook(id);
        return true;
    }


}