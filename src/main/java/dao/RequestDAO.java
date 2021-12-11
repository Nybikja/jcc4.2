package dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "request")
@Data
public class RequestDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_id")
    int userId;

    @Column(name = "book_id")
    int bookId;

    @Basic
    private java.sql.Date time;
}
