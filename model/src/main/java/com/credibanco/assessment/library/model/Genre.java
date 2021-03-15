package com.credibanco.assessment.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "LM_GENRE")
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence_Genre")
    @SequenceGenerator(name = "id_Sequence_Genre", sequenceName = "ID_SEQ_GENRE")
    private Long id;

    @NotNull
    @Column(name = "GENRE_DESCRIPTION")
    private String genreDescription;
}