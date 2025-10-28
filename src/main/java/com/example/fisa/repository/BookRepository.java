package com.example.fisa.repository;

import com.example.fisa.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                  // 자료형, id의 자료형
public interface BookRepository extends JpaRepository<Book, Long> {
    // 기본 메서드는 구현이 되어있다.
//    List<Book> getAllBooks();
}
