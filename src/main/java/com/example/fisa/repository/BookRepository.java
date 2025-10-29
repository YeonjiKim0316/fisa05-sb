package com.example.fisa.repository;

import com.example.fisa.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                                  // 자료형, id의 자료형
public interface BookRepository extends JpaRepository<Book, Long> {

    // id 를 통해 사용되는 기본 메서드가 아닌 경우에는 jpa 규칙에 맞게 생성해 줍니다.
    List<Book> findByTitleAndAuthor(String title, String author);

    List<Book> findByTitleOrAuthor(String title, String author);

    List<Book> findByTitleContaining(String title);

    List<Book> findByPageBetween(int minPage, int maxPage);
    // 기본 메서드는 구현이 되어있다.
//    List<Book> getAllBooks(); "select * from books;"
}
