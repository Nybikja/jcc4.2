package dao;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
//@Data
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

    @Column
    private int rating;

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RequestDAO> request = new ArrayList<>();

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RentDAO> rent = new ArrayList<>();

    @ManyToMany(
            mappedBy = "books",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<AuthorDAO> authors = new ArrayList<>();

    public BookDAO() {
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public int getAmountGave() {
        return amountGave;
    }

    public void setAmountGave(int amountGave) {
        this.amountGave = amountGave;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<RequestDAO> getRequest() {
        return request;
    }

    public void setRequest(List<RequestDAO> request) {
        this.request = request;
    }

    public List<AuthorDAO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDAO> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "BookDAO{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", amountLeft=" + amountLeft +
                ", amountGave=" + amountGave +
                ", rating=" + rating +
                '}';
    }
}
