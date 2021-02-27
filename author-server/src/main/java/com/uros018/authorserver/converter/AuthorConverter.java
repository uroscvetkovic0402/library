package com.uros018.authorserver.converter;

import com.uros018.authorserver.dto.AuthorDtoRequest;
import com.uros018.authorserver.entity.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorEntity convertAuthorDto(AuthorDtoRequest authorDtoRequest){
        AuthorEntity authorEntity=new AuthorEntity();

        authorEntity.setAuthorFirstName(authorDtoRequest.getAuthorFirstName());
        authorEntity.setAuthorLastName(authorDtoRequest.getAuthorLastName());

        return authorEntity;
    }
}
