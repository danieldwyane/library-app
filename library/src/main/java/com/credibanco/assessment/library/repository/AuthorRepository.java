package com.credibanco.assessment.library.repository;

import java.util.List;

import com.credibanco.assessment.library.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFullNameContainingIgnoreCase(String fullName);
}