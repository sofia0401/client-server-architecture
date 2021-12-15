package com.example.pract6.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "author")
    private String author;
    @Column(name = "language")
    private String language;


}