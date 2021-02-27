package com.uros018.bookserver.controller;

import com.uros018.bookserver.dto.BookDtoRequest;
import com.uros018.bookserver.entity.BookEntity;
import com.uros018.bookserver.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public BookEntity addBook(@RequestBody  BookDtoRequest bookDtoRequest){

        log.info("Inside addBook - BookController");
        return bookService.addBook(bookDtoRequest);

    }

    @GetMapping("/find/{id}")
    public BookEntity findByBookId(@PathVariable("id") Long id){
        log.info("Inside findByBookId - BookController");
        return bookService.findByBookId(id);
    }

}
