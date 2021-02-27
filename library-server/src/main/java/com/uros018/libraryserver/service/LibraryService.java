package com.uros018.libraryserver.service;

import com.uros018.libraryserver.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class LibraryService {
    @Autowired
    RestTemplate restTemplate;

    public BookAndAuthorDtoResponse addBook(BookWithAuthorDtoRequest bookWithAuthorDtoRequest){
        log.info("Inside addBook - LibraryService /n SAVING AUTHOR");

        String authorUrl = "http://localhost:9002/author/add";
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Accept",MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity <AuthorDtoRequest> requestAuthor=new HttpEntity<>(bookWithAuthorDtoRequest.getAuthorDtoRequest(),httpHeaders);
        AuthorDtoResponse authorDtoResponse=restTemplate.postForObject(authorUrl,requestAuthor,AuthorDtoResponse.class);

        log.info("Setting up authorId in bookWithAuthorRequest");
        bookWithAuthorDtoRequest.getBookDtoRequest().setAuthorId(authorDtoResponse.getAuthorEntityId());



        log.info("Inside addBook - LibraryService /n SAVING BOOK");

        String bookUrl = "http://localhost:9001/book/add";

        HttpEntity <BookDtoRequest> requestBook=new HttpEntity <> (bookWithAuthorDtoRequest.getBookDtoRequest(),httpHeaders);
        BookDtoResponse bookDtoResponse=restTemplate.postForObject(bookUrl,requestBook,BookDtoResponse.class);




       BookAndAuthorDtoResponse bookAndAuthorDtoResponse=new BookAndAuthorDtoResponse();
       bookAndAuthorDtoResponse.setBookDtoResponse(bookDtoResponse);
       bookAndAuthorDtoResponse.setAuthorDtoResponse(authorDtoResponse);

       return bookAndAuthorDtoResponse;

    }


    public BookAndAuthorDtoResponse findByBookId(Long id){
        log.info("Inside findByBookId - LibraryService");

        String bookUrl = "http://localhost:9001/book/find/"+id;
        BookDtoResponse bookDtoResponse=restTemplate.getForObject(bookUrl,BookDtoResponse.class);


        String authorUrl = "http://localhost:9002/author/find/"+bookDtoResponse.getAuthorEntityId();
        AuthorDtoResponse authorDtoResponse=restTemplate.getForObject(authorUrl,AuthorDtoResponse.class);

        BookAndAuthorDtoResponse bookAndAuthorDtoResponse=new BookAndAuthorDtoResponse();
        bookAndAuthorDtoResponse.setAuthorDtoResponse(authorDtoResponse);
        bookAndAuthorDtoResponse.setBookDtoResponse(bookDtoResponse);

        return bookAndAuthorDtoResponse;
    }


}
