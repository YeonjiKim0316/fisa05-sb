package com.example.fisa.controller;

import com.example.fisa.dao.Book;
import com.example.fisa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return bookService.getAllBooks();
        // loose coupling을 위해서 controller는 service와만 통신합니다.
    }

    // 책을 삽입하는 메서드
    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    // 특정 책을 ID로 조회
    @GetMapping("/{id}") // @PathVariable
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    // 특정 책을 ID로 삭제
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    // 특정 책의 ID와 수정 내용 전부를 받아서 변경
    @PutMapping("/{id}")
    public void updateBookById(@PathVariable Long id, @RequestBody Book book) {
        // 1. 전체 내용을 books 테이블에서 조회
        book.setId(id);
        // 2. 클라이언트가 준 book의 내용으로 변경사항을 모두 반영
        // 3. 그 결과를 sevice를 통해 repo로 전달
        bookService.saveBook(book);
    }

    // 특정 책의 ID와 수정할 내용만 받아서 변경
    @PatchMapping("/{id}")
    public void updateBookById2(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBookById2(id, book);
    }

}
