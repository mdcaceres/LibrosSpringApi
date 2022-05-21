package com.mdcaceres.BooksApi.Services;
import com.mdcaceres.BooksApi.DTOs.BookDto;
import com.mdcaceres.BooksApi.DTOs.UpdateBookDto;
import com.mdcaceres.BooksApi.Data.AuthorRepository;
import com.mdcaceres.BooksApi.Data.BookRepository;
import com.mdcaceres.BooksApi.Models.Author;
import com.mdcaceres.BooksApi.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class BookService {
    @Autowired
    BookRepository booksRepo;
    @Autowired
    AuthorRepository authorsRepo;

    public List<Book> getAll() {
        return booksRepo.findAll();
    }

    public Book findById(int id) {
        return booksRepo
                .findById(id)
                .orElse(null);
    }

    public List<Book> findBooksByAuthorName(String name){
        return booksRepo.findBookByAuthor_NameIsContainingIgnoreCase(name);
    }

    public List<Book> findBooksByTitle(String name){
        return booksRepo.findAllByTitleContainingIgnoreCaseOrderByTitle(name);
    }


    public Book save(BookDto dto){
        Author author = authorsRepo
                .findById(dto.getAuthorId())
                .orElse(null);
        if(author == null) return null;
        else {
            Book book = new Book(dto.getTitle(), author);
            return booksRepo.save(book);
        }
    }

    public Book updateBook(UpdateBookDto updatedBook){
        Author author = authorsRepo
                .findById(updatedBook.getAuthorId())
                .orElse(null);
        if(author == null) return null;
        else {
            Book book = new Book(updatedBook.getTitle(), author);
            book.setId(updatedBook.getBookId());
            return booksRepo.save(book);
        }
    }

    public boolean delete(int id){
        try{
            booksRepo.deleteById(id);
            return true;
        } catch(RuntimeException e) {
            System.out.println(e);
            return false;
        }
    }
}
