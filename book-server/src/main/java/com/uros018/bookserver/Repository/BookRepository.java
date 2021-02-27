package com.uros018.bookserver.Repository;

import com.uros018.bookserver.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    BookEntity findByBookEntityId(Long bookId);
}
