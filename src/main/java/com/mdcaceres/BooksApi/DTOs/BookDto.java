package com.mdcaceres.BooksApi.DTOs;

public class BookDto {
    private String title;

    private int authorId;

    public BookDto(String title, int authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
