package models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rent")
//@Data
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "time_taken")
    private java.sql.Date timeTaken;

    @Basic
    @Column(name = "time_should_be_returned")
    private java.sql.Date timeShouldBeReturned;

    @Basic
    @Column(name = "time_returned")
    private java.sql.Date timeReturned;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private User user;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Book book;

    public Rent() {
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
        return "Rent{" +
                "id=" + id +
                ", timeTaken=" + timeTaken +
                ", timeShouldBeReturned=" + timeShouldBeReturned +
                ", timeReturned=" + timeReturned +
                '}';
    }
}