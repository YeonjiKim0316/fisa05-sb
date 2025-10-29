package com.example.fisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // RESTApi로 통신
@RequestMapping("/")   // @WebServlet("/hello")
public class HelloController {

    @GetMapping // doGet 받아와서 overide - redirect / request.dispatcher(
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    // Controller / RestController를 혼용해서 쓰지는 않습니다.
//    @GetMapping("/{id}") // PathVariable localhost:8080/atangi?test=1
//    public String sayHello(@PathVariable String id, @RequestParam(value="name", defaultValue = "Guest") String test) {
//        return "Hello, " + id + " / " + test;
//    }
//    @PostMapping
//    @DeleteMapping
//    @PutMapping
}