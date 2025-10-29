package com.example.fisa.controller;

import com.example.fisa.dao.Book;
import com.example.fisa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // 객체를 주입
    @Autowired // 생략해도 무관
    private final BookService bookService;

    // 생성자
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks(); // loose coupling을 위해서 controller는 service와만 통신합니다.
    }

    // 책을 삽입하는 메서드
    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
}
