package com.company.jcc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_surname")
    private String authorSurname;

    @Column(name = "coauthor_exists")
    private int coAuthorExists;



    public Author() {
    }

    public Author(String authorName, String authorSurname, int coAuthorExists) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.coAuthorExists = coAuthorExists;
    }

    public Integer getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public int isCoAuthorExists() {
        return coAuthorExists;
    }

    public void setCoAuthorExists(int coAuthorExists) {
        this.coAuthorExists = coAuthorExists;
    }

    @Override
    public String toString() {
        return "\n Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", coAuthorExists=" + coAuthorExists +
                '}' + "\n";
    }
}