package com.example.demo.controller;

import com.example.demo.dto.AllBooksResponseDto;
import com.example.demo.dto.BookRequestDto;
import com.example.demo.dto.BookResponseDto;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/api/books")
    public BookResponseDto save(@RequestBody BookRequestDto bookRequestDto){
        return bookService.save(bookRequestDto);
    }


    @GetMapping("/api/books/all")
    public List<AllBooksResponseDto> getAll() {
        return bookService.getAll();
    }
}
