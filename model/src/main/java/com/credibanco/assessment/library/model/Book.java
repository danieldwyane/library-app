package com.credibanco.assessment.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LM_BOOK")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence_Book")
    @SequenceGenerator(name = "id_Sequence_Book", sequenceName = "ID_SEQ_BOOK")
    private Long id;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @Column(name = "YEAR")
    private int year;

    @ManyToOne
    @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID", nullable = false)
    private Genre genre;

    @NotNull
    @Column(name = "PAGES_NUMBER")
    private int pagesNumber;

    @ManyToOne
    @JoinColumn(name = "EDITORIAL_ID", referencedColumnName = "ID", nullable = true)
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID", nullable = false)
    private Author author;
}