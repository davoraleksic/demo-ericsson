package com.example.demo.service.impl;

import com.example.demo.dto.AllBooksResponseDto;
import com.example.demo.dto.BookRequestDto;
import com.example.demo.dto.BookResponseDto;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setPublishYear(bookRequestDto.getPublishYear());
        book.setAuthorFirstName(bookRequestDto.getAuthorFirstName());

        Book savedBook = bookRepository.save(book);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(savedBook.getTitle());

        return bookResponseDto;
    }

    @Override
    public List<AllBooksResponseDto> getAll() {
        List<Book> all = bookRepository.findAll();
        List<AllBooksResponseDto> savedBooks = new ArrayList<>();
        for(Book book : all) {
            AllBooksResponseDto allBooksResponseDto = new AllBooksResponseDto();
            allBooksResponseDto.setId(book.getId());
            allBooksResponseDto.setTitle(book.getTitle());
            allBooksResponseDto.setPublishYear(book.getPublishYear());
            allBooksResponseDto.setAuthorFirstName(book.getAuthorFirstName());
            allBooksResponseDto.setAuthorLastName(book.getAuthorLastName());
            savedBooks.add(allBooksResponseDto);
        }
        return savedBooks;
    }
}
