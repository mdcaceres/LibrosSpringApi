package com.mdcaceres.BooksApi.Controllers;
import com.mdcaceres.BooksApi.DTOs.BookDto;
import com.mdcaceres.BooksApi.DTOs.UpdateBookDto;
import com.mdcaceres.BooksApi.Models.Book;
import com.mdcaceres.BooksApi.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> lst = bookService.getAll();
        if(!lst.isEmpty()){
            return ResponseEntity.ok(lst);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        Book book = bookService.findById(id);
        if(book != null){
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/author/{name}")
    public ResponseEntity<List<Book>> getBooksByAuthorName(@PathVariable String name){
        List<Book> book = bookService.findBooksByAuthorName(name);
        if(!book.isEmpty()){
            return ResponseEntity.ok(book);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title){
        List<Book> book = bookService.findBooksByTitle(title);
        if(!book.isEmpty()){
            return ResponseEntity.ok(book);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody BookDto dto){
        Book b = bookService.save(dto);
        if(b != null){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Book> updateBookById(@RequestBody UpdateBookDto updated){
        Book updateBook = bookService.updateBook(updated);
        if(updateBook!=null){
            return ResponseEntity.ok(updateBook);
        } else{
            return ResponseEntity.badRequest().build();
           }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable int id){
        boolean response = bookService.delete(id);
        if(response) return ResponseEntity.noContent().build();
        else return ResponseEntity.badRequest().build();
    }

}
