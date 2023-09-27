package com.springbootpagination.controller;

import com.springbootpagination.model.Book;
import com.springbootpagination.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;
    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize,@RequestParam Integer pageNumber,@RequestParam String sortBy,@RequestParam String sortDirection){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.fromString(sortDirection), sortBy));
        return bookRepository.findAll(pageable);
    }
    @GetMapping("/pagination")
    public Page<Book> pagination(Pageable pageable ){
        return bookRepository.findAll(pageable);
    }
    @GetMapping("/slice")
    public Slice<Book> slice(Pageable pageable ){
        //daha performanslı farklı diğeri kaç kayıt var bilirken bu sadece şuankinden sonra kayıt varmı yok mu bilir
        return bookRepository.findAll(pageable);
    }
}
