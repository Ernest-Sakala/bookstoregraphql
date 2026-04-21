package com.cs.unza.zm.bookstore.config.web;


import com.cs.unza.zm.bookstore.model.Book;
import com.cs.unza.zm.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Seeds the database with sample books on every startup.
 * Remove or comment out in production.
 */
@Component
public class DataSeeder  {

    private final BookRepository bookRepo;

    public DataSeeder(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

//    @Override
//    public void run(String... args) {
//        if (bookRepo.count() > 0) return;   // already seeded
//
//        bookRepo.saveAll(List.of(
//            Book.builder()
//                .title("Clean Code")
//                .author("Robert C. Martin")
//                .category("Programming")
//                .price(299.00)
//                .description("A handbook of agile software craftsmanship.")
//                .build(),
//            Book.builder()
//                .title("The Pragmatic Programmer")
//                .author("David Thomas & Andrew Hunt")
//                .category("Programming")
//                .price(349.00)
//                .description("Your journey to mastery.")
//                .build(),
//            Book.builder()
//                .title("Design Patterns")
//                .author("Gang of Four")
//                .category("Software Architecture")
//                .price(399.00)
//                .description("Elements of reusable object-oriented software.")
//                .build(),
//            Book.builder()
//                .title("Spring Boot in Action")
//                .author("Craig Walls")
//                .category("Java")
//                .price(279.00)
//                .description("A practical guide to Spring Boot development.")
//                .build(),
//            Book.builder()
//                .title("JavaScript: The Good Parts")
//                .author("Douglas Crockford")
//                .category("JavaScript")
//                .price(199.00)
//                .description("Unearthing the excellence in JavaScript.")
//                .build(),
//            Book.builder()
//                .title("You Don't Know JS")
//                .author("Kyle Simpson")
//                .category("JavaScript")
//                .price(249.00)
//                .description("A deep dive into the JavaScript language.")
//                .build()
//        ));
//
//        System.out.println("[DataSeeder] ✅ Seeded 6 sample books.");
//    }
}
