package dao;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rent")
@Data
public class RentDAO {

    private int userId;

    private int bookId;

    @Basic
    @Column(name = "time_taken")
    private java.sql.Date timeTaken;

    @Basic
    @Column(name = "time_should_be_returned")
    private java.sql.Date timeShouldBeReturned;

    @Basic
    @Column(name = "time_returned")
    private java.sql.Date timeReturned;

}
