package com.springbootpagination.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private LocalDateTime publishedDate;
}
