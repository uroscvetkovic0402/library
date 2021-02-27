package com.uros018.authorserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorEntityId;
    private String authorFirstName;
    private String authorLastName;
}
