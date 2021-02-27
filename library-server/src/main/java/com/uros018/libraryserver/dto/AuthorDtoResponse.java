package com.uros018.libraryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDtoResponse {

    private Long authorEntityId;
    private String authorFirstName;
    private String authorLastName;
}
