package dao;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "request")
//@Data
public class RequestDAO {
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
    private UserDAO user;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private BookDAO book;

    public RequestDAO() {
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        return "RequestDAO{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
