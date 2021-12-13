package models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "request")
//@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Basic
    @Column
    private java.sql.Date time;

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

    public Request() {
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        return "Request{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
