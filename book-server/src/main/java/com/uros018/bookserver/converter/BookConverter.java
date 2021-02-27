package com.uros018.bookserver.converter;

import com.uros018.bookserver.dto.BookDtoRequest;
import com.uros018.bookserver.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookEntity convertBookDto(BookDtoRequest bookDtoRequest){
        BookEntity bookEntity=new BookEntity();

        bookEntity.setBookEntityName(bookDtoRequest.getBookName());
        bookEntity.setAuthorEntityId(bookDtoRequest.getAuthorId());

        return bookEntity;
    }
}
