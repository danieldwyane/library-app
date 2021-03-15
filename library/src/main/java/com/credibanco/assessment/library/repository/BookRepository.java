package com.credibanco.assessment.library.repository;

import java.util.List;
import java.util.Optional;

import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.model.Editorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT COUNT(b.id) FROM Book b WHERE b.editorial = ?1")
    int countBooksByEditorial(Editorial editorial);

    List<Book> findByTitle(String title);

    List<Book> findByYear(int year);

    List<Book> findByAuthorInAndTitleContainingIgnoreCaseAndYear(List<Author> listAuthor, String title, int year);

    Optional<Book> findByTitleAndAuthorAndEditorial(String title, Author author, Editorial editorial);
}