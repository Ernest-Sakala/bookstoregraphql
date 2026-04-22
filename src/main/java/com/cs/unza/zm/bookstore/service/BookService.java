package com.cs.unza.zm.bookstore.service;

import com.cs.unza.zm.bookstore.model.Book;
import com.cs.unza.zm.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public List<Book> search(String search){
        return repository.search(search);
    }

    public Book getBookById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book createBook(String title, String author) {
        Book book = new Book(title, author);
        return repository.save(book);
    }

    public Book createBook(String title, String author, String category, String imageSlug, String filePath) {
        Book book = new Book(title, author, category, imageSlug, filePath);
        return repository.save(book);
    }


    public Book uploadBook(String title,
                           String author,
                           String category,
                           MultipartFile image,
                           MultipartFile file) throws IOException {

        // Create directories if they don't exist
        Path imageDir = Path.of("uploads/images");
        Path fileDir = Path.of("uploads/files");

        Files.createDirectories(imageDir);
        Files.createDirectories(fileDir);

        // Save files
        String imageSlug = image.getOriginalFilename();
        String filePath = fileDir.resolve(file.getOriginalFilename()).toString();

        image.transferTo(imageDir.resolve(imageSlug));
        file.transferTo(Path.of(filePath));

        // Save book in DB
        Book book = new Book(title, author, category, imageSlug, filePath);

        return repository.save(book);
    }

    public void deleteBook(Integer id) {
        repository.deleteById(id);
    }


}