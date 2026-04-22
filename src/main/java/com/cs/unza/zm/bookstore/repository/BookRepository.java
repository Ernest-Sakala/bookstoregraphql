package com.cs.unza.zm.bookstore.repository;

import com.cs.unza.zm.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("""
        SELECT b FROM Book b
        WHERE LOWER(b.title)  LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.author) LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.category) LIKE LOWER(CONCAT('%',:q,'%'))
        """)
    List<Book> search(@Param("q") String query);
}
