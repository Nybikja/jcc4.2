package dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class BookDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "amount_left")
    private int amountLeft;

    @Column(name = "amount_gave")
    private int amountGave;

    private int rating;
}
