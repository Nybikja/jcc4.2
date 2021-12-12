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
//    private int userId;
//    private int bookId;

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


}