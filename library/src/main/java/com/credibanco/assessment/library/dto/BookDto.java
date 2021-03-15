package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Genre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private int year;

    private Genre genre;

    private int pagesNumber;

    private Editorial editorial;

    private Author author;
}