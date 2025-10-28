package com.example.fisa.repository;

import com.example.fisa.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                  // 자료형, id의 자료형
public interface BookRepository extends JpaRepository<Book, Long> {
}
