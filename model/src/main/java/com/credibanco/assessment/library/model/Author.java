package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "LM_AUTHOR")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence_Author")
    @SequenceGenerator(name = "id_Sequence_Author", sequenceName = "ID_SEQ_AUTHOR")
    private Long id;

    @NotNull
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "ORIGIN_CITY")
    private String originCity;

    @Column(name = "EMAIL")
    private String email;
}