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
@Table(name = "LM_EDITORIAL")
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence_Editorial")
    @SequenceGenerator(name = "id_Sequence_Editorial", sequenceName = "ID_SEQ_EDITORIAL")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    @NotNull
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "MAXIMUM_BOOKS")
    private int maximumBooks;
}