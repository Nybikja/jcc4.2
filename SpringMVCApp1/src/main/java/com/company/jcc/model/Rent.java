package com.company.jcc.model;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "time_taken")
    private Date timeTaken;

    @Basic
    @Column(name = "time_should_be_returned")
    private Date timeShouldBeReturned;

    @Basic
    @Column(name = "time_returned")
    private Date timeReturned;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Rent() {
    }

    public Rent(User user, Book book, Date timeTaken, Date timeShouldBeReturned) {
        this.user = user;
        this.book = book;
        this.timeTaken = timeTaken;
        this.timeShouldBeReturned = timeShouldBeReturned;
    }

    public Date getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Date timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Date getTimeShouldBeReturned() {
        return timeShouldBeReturned;
    }

    public void setTimeShouldBeReturned(Date timeShouldBeReturned) {
        this.timeShouldBeReturned = timeShouldBeReturned;
    }

    public Date getTimeReturned() {
        return timeReturned;
    }

    public void setTimeReturned(Date timeReturned) {
        this.timeReturned = timeReturned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "\n Rent{" +
                "id=" + id +
                ", timeTaken=" + timeTaken +
                ", timeShouldBeReturned=" + timeShouldBeReturned +
                ", timeReturned=" + timeReturned +
                '}' + "\n";
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return id == rent.id && timeTaken.equals(rent.timeTaken) && timeShouldBeReturned.equals(rent.timeShouldBeReturned) && Objects.equals(timeReturned, rent.timeReturned) && user.equals(rent.user) && book.equals(rent.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeTaken, timeShouldBeReturned, timeReturned, user, book);
    }
}