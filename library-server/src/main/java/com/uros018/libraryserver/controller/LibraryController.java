package com.uros018.libraryserver.controller;

import com.uros018.libraryserver.dto.*;
import com.uros018.libraryserver.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public BookAndAuthorDtoResponse addBook(@RequestBody  BookWithAuthorDtoRequest bookWithAuthorDtoRequest){
        log.info("Inside addBook - BookController");

        return libraryService.addBook(bookWithAuthorDtoRequest);
    }

    @GetMapping("/find/{id}")
    public BookAndAuthorDtoResponse findByBookId(@PathVariable("id") Long id){
        log.info("Inside findByBookId - BookController");
        return libraryService.findByBookId(id);
    }
}
