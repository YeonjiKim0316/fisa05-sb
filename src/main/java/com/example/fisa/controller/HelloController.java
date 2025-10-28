package com.example.fisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // RESTApi로 통신
@RequestMapping("/hello")   // @WebServlet("/hello)
public class HelloController {

    @GetMapping // doGet 받아와서 overide - redirect / request.dispatcher(
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

//    @PostMapping
//    @DeleteMapping
//    @PutMapping
}