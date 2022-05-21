package com.mdcaceres.BooksApi.Data;
import com.mdcaceres.BooksApi.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findBookByAuthor_NameIsContainingIgnoreCase(String name);
    List<Book> findAllByTitleContainingIgnoreCaseOrderByTitle(String name);
}
