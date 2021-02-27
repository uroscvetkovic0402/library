package com.uros018.authorserver.service;

import com.uros018.authorserver.converter.AuthorConverter;
import com.uros018.authorserver.dto.AuthorDtoRequest;
import com.uros018.authorserver.entity.AuthorEntity;
import com.uros018.authorserver.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorConverter authorConverter;

    public AuthorEntity addAuthor(AuthorDtoRequest authorDtoRequest) {
        log.info("Inside addAuthor - AuthorService");
        return authorRepository.save(authorConverter.convertAuthorDto(authorDtoRequest));
    }


    public AuthorEntity findByAuthorId(Long id) {
        log.info("Inside addAuthor - AuthorService");
        return authorRepository.findByAuthorEntityId(id);
    }
}
