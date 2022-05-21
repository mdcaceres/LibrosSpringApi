package com.mdcaceres.BooksApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="autores")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;

    @Column(
            name ="nombre",
            nullable = false
    )
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
    @JsonIgnore
    private Set<Book> books;


    public Author() {

    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
