package com.uros018.bookserver.service;

import com.uros018.bookserver.Repository.BookRepository;

import com.uros018.bookserver.converter.BookConverter;
import com.uros018.bookserver.dto.BookDtoRequest;
import com.uros018.bookserver.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;



//    public BookAndAuthorDtoResponse saveBook(BookAndAuthorDtoRequest bookAndAuthorDtoRequest){
//        log.info("Inside saveBook method - BookService");
//        String http="http://localhost:9002/author/save";
//
//        HttpEntity<AuthorDtoRequest> httpEntity=new HttpEntity<>(bookAndAuthorDtoRequest.getAuthorDtoRequest());
//        ResponseEntity<AuthorDtoResponse> responseEntity=restTemplate.postForEntity(http,httpEntity,AuthorDtoResponse.class);
//        AuthorDtoResponse authorDtoResponse=responseEntity.getBody();
//
//        BookEntity bookEntity=new BookEntity();
//        bookEntity.setAuthorId(authorDtoResponse.getAuthorId());
//                bookRepository.save(bookDtoConverter.convertBookDto(bookAndAuthorDtoRequest));
//        BookAndAuthorDtoResponse bookAndAuthorDtoResponse=new BookAndAuthorDtoResponse();
//        bookAndAuthorDtoResponse.setBookEntity(bookEntity);
//        bookAndAuthorDtoResponse.setAuthorDtoResponse(authorDtoResponse);
//
//        return bookAndAuthorDtoResponse;
//
//    }

    public BookEntity findByBookId(Long bookId){
        log.info("Inside findByBookId method - BookService ");
        return bookRepository.findByBookEntityId(bookId);
    }

    @Autowired
    private BookConverter bookConverter;

    public BookEntity addBook(BookDtoRequest bookDtoRequest) {
        log.info("Inside addBook - BookService");
        return bookRepository.save(bookConverter.convertBookDto(bookDtoRequest));

    }
}
