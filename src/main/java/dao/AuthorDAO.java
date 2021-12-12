package dao;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
//@Data
public class AuthorDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author_name;
    private String author_surname;

    @Column(name = "coauthor_exists")
    private boolean coAuthorExists;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BookDAO> books = new ArrayList<>();

    public AuthorDAO() {
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_surname() {
        return author_surname;
    }

    public void setAuthor_surname(String author_surname) {
        this.author_surname = author_surname;
    }

    public boolean isCoAuthorExists() {
        return coAuthorExists;
    }

    public void setCoAuthorExists(boolean coAuthorExists) {
        this.coAuthorExists = coAuthorExists;
    }

    public List<BookDAO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDAO> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorDAO{" +
                "id=" + id +
                ", author_name='" + author_name + '\'' +
                ", author_surname='" + author_surname + '\'' +
                ", coAuthorExists=" + coAuthorExists +
                '}';
    }
}
