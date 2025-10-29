package com.example.fisa.controller;

import com.example.fisa.dao.Book;
import com.example.fisa.service.BookService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
//@Tag(name = "swagger 테스트 API", description = "swagger 테스트를 진행하는 API")
@Controller // @RestController가 아니면 swagger 사용 불가
@RequestMapping("/books")
public class BookController {



    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 📘 책 목록 조회
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        log.info("책 전체 목록 조회: {}권", books.size());
        return "bookmain"; // bookmain.html로 model 객체 가지고 이동
    }

    // ➕ 책 추가 폼
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book()); // 폼 바인딩용 빈 객체
        log.info("책 추가 폼 진입");
        return "fragments/form-add"; // bookmain.html + form-add fragment
    }


    @GetMapping("/{id}") // 동적으로 바뀌는 값 @PathVariable 사용
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }


    // 💾 책 저장
    @PostMapping
    public String saveBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        log.info("책 추가: {} / {}", book.getTitle(), book.toString());
        return "redirect:/books"; // 저장 후 목록으로 리다이렉트
    }

    // 🔍 책 검색 폼
    @GetMapping("/search")
    public String searchForm() {
        return "form-search"; //bookmain.html + form-search fragment
    }

    // 📊 조건 검색
    @GetMapping("/select4")
    public String searchBooks(@RequestParam String title,
                              @RequestParam String author,
                              Model model) {
        List<Book> results = bookService.getBookByTitleContainingOrAuthorContaining(title, author);


        model.addAttribute("books", results);
        return "bookmain"; // 검색 결과는 목록 fragment로 출력
    }

    // 🗑 삭제
    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBookForm(@PathVariable Long id, Model model) {
        Optional<Book> bookOptional = bookService.getBookById(id);
        if (bookOptional.isPresent()) {
            model.addAttribute("book", bookOptional.get());
            return "form-edit";
        } else {
            return "redirect:/books"; // 존재하지 않으면 목록으로
        }
    }

    // ✏️ 수정
    @PostMapping("/{id}/update")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

}
