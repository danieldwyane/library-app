package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookReportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private int year;

    private String genre;

    private int pagesNumber;

    private String editorial;

    private String author;
}