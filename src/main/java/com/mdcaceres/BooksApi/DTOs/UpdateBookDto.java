package com.mdcaceres.BooksApi.DTOs;

public class UpdateBookDto {
    private int bookId;
    private String title;

    private int authorId;

    public UpdateBookDto(int bookId, String title, int authorId) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
