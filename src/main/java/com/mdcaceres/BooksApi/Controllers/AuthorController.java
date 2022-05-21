package com.mdcaceres.BooksApi.Controllers;
import com.mdcaceres.BooksApi.DTOs.AuthorDto;
import com.mdcaceres.BooksApi.DTOs.UpdateAuthorDto;
import com.mdcaceres.BooksApi.Models.Author;
import com.mdcaceres.BooksApi.Models.Book;
import com.mdcaceres.BooksApi.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        if(authors != null) return ResponseEntity.ok(authors);
        else return ResponseEntity.notFound().build();
    }

   @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id){
       Author author = authorService.findById(id);
       if(author != null){
           return ResponseEntity.ok(author);
       } else {
           return ResponseEntity.notFound().build();
       }
    }

    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto dto){
        Author author = authorService.save(dto);
        if(author!=null) return ResponseEntity.ok(author);
        else return ResponseEntity.badRequest().build();
    }


    @PutMapping("/")
    public ResponseEntity<Author> updateAuthorById(@RequestBody UpdateAuthorDto updated){
        Author author = authorService.updateAuthor(updated);
        if(author!=null) return ResponseEntity.ok(author);
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthorById(@PathVariable int id){
        boolean response = authorService.deleteAuthor(id);
        if(response) return ResponseEntity.noContent().build();
        else return ResponseEntity.badRequest().build();
    }
}
