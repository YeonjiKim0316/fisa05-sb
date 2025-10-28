package com.example.fisa.controller;

import com.example.fisa.dao.Book;
import com.example.fisa.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // 객체를 주입
    private final BookService bookService;

    // 생성자
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks(); // loose coupling을 위해서 controller는 service와만 통신합니다.
    }
}
