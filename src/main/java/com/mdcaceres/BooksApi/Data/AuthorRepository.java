package com.mdcaceres.BooksApi.Data;
import com.mdcaceres.BooksApi.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
