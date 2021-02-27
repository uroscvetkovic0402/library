package com.uros018.authorserver.repository;

import com.uros018.authorserver.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {


    AuthorEntity findByAuthorEntityId(Long id);
}
