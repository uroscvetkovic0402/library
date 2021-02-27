package com.uros018.authorserver.controller;

import com.uros018.authorserver.dto.AuthorDtoRequest;
import com.uros018.authorserver.entity.AuthorEntity;
import com.uros018.authorserver.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public AuthorEntity addAuthor(@RequestBody AuthorDtoRequest authorDtoRequest){
        log.info("Inside addAuthor - AuthorController");

        return authorService.addAuthor(authorDtoRequest);
    }

    @GetMapping("/find/{id}")
    public AuthorEntity findByAuthorId(@PathVariable("id") Long id){
        log.info("Inside findByAuthorId - AuthorController");
        return authorService.findByAuthorId(id);
    }
}
