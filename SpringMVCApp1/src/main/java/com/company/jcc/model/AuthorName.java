package com.company.jcc.model;

import javax.persistence.*;

@Entity
@Table(name = "authors_name")
public class AuthorName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AuthorName() {
    }

    public AuthorName(Integer id, Author author, Book book) {
        this.id = id;
        this.author = author;
        this.book = book;
    }
}
