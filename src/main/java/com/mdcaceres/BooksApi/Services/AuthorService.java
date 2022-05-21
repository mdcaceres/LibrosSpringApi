package com.mdcaceres.BooksApi.Services;

import com.mdcaceres.BooksApi.DTOs.AuthorDto;
import com.mdcaceres.BooksApi.DTOs.BookDto;
import com.mdcaceres.BooksApi.DTOs.UpdateAuthorDto;
import com.mdcaceres.BooksApi.Data.AuthorRepository;
import com.mdcaceres.BooksApi.Models.Author;
import com.mdcaceres.BooksApi.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class AuthorService {
    @Autowired
    AuthorRepository authorRepo;

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author findById(int id) {
        return authorRepo
                .findById(id)
                .orElse(null);
    }

    public Author save(AuthorDto dto){
        Author author = new Author();
        author.setName(dto.getName());
        return authorRepo.save(author);
    }

    public Author updateAuthor(UpdateAuthorDto updated) {
        return authorRepo.save(new Author(updated.getId(), updated.getName()));
    }

    public boolean deleteAuthor(int id) {
        try{
            authorRepo.deleteById(id);
            return true;
        } catch(RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }
}
