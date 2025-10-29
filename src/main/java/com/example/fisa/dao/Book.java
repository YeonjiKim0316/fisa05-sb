package com.example.fisa.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id // PK로 지정
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    String title;
    String author;
    int page;
    String genre;
    int price;
}
