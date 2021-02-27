package com.uros018.libraryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAndAuthorDtoResponse {

    private BookDtoResponse bookDtoResponse;
    private AuthorDtoResponse authorDtoResponse;
}
