package com.example.fisa.service;

import com.example.fisa.dao.Book;
import com.example.fisa.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Optional<Book> -> null이 있을 때 예외처리해주는 Wrapper Class입니다. {}
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBookById2(Long id, Book book) {
        // 1. 전체 내용을 books 테이블에서 조회
        // 2. 입력받은 필드가 원본 행에 있는지 확인한다
        // -1. 원본의 값과 새로 받은 특정 필드의 값이 일치하는지 확인 후 수정
        // 3. 그 결과를 sevice를 통해 repo로 전달
    }
}
