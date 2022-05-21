package com.mdcaceres.BooksApi.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mdcaceres.BooksApi.Models.Book;

import javax.persistence.*;
import java.util.Set;

public class AuthorDto {
    private String name;

    public AuthorDto() {

    }

    public AuthorDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
