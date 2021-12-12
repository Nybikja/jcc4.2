package dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rent")
//@Data
public class RentDAO {
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
    private UserDAO user;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private BookDAO book;

    public RentDAO() {
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

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public BookDAO getBook() {
        return book;
    }

    public void setBook(BookDAO book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "RentDAO{" +
                "id=" + id +
                ", timeTaken=" + timeTaken +
                ", timeShouldBeReturned=" + timeShouldBeReturned +
                ", timeReturned=" + timeReturned +
                '}';
    }
}