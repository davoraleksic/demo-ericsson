package com.example.demo.service;

import com.example.demo.dto.AllBooksResponseDto;
import com.example.demo.dto.BookRequestDto;
import com.example.demo.dto.BookResponseDto;
import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    BookResponseDto save(BookRequestDto bookRequestDto);

    List<AllBooksResponseDto> getAll();

}
