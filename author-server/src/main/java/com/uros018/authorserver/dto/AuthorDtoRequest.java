package com.uros018.authorserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDtoRequest {
    private String authorFirstName;
    private String authorLastName;
}
