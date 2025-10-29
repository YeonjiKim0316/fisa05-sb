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

    public Book updateBookById2(Long id, Book book) {
        // 1. 전체 내용을 books 테이블에서 조회
//        Optional<Book> existingBook = bookRepository.findById(id);
        Book existingBook = bookRepository.findById(id).orElse(null); // 없는 책을 조회하는 경우 null을 리턴 
        // 2. 입력받은 필드가 원본 행에 있는지 확인한다
        if (book.getTitle() != null) {
            // 책 이름이 기존과 다르면 책 이름을 변경
            existingBook.setTitle(book.getTitle());
        } else if (book.getAuthor() != null) {
            existingBook.setAuthor(book.getAuthor());
        } else if (book.getPage() != 0) {
            existingBook.setPage(book.getPage());
        }

        // 3. 그 결과를 sevice를 통해 repo로 전달
        return bookRepository.save(existingBook);
    }

    public List<Book> getBookByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author);
    }

    public List<Book> getBookByTitleOrAuthor(String title, String author) {
        return bookRepository.findByTitleOrAuthor(title, author);
    }

    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> getBookByPage(int minPage, int maxPage) {
        return bookRepository.findByPageBetween(minPage, maxPage);
    }

    public List<Book> getBookByTitleContainingOrAuthorContaining(String title, String author) {
        return bookRepository.findByTitleContainingOrAuthorContaining(title, author);
    }
}
