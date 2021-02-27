package com.uros018.libraryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDtoResponse {

    private Long bookEntityId;
    private String bookEntityName;
    private Long authorEntityId;
}
