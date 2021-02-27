package com.uros018.libraryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookWithAuthorDtoRequest {

    private BookDtoRequest bookDtoRequest;
    private AuthorDtoRequest authorDtoRequest;
}
