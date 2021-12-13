package service;

import dao.BookDao;
import models.Book;

public class BookService {

    private BookDao bookDao = new BookDao();

    public void save(String bookTitle, int amountLeft, int amountGave, int rating){
        bookDao.save(new Book(bookTitle, amountLeft, amountGave, rating));
    }

    public Book findById(int id) {
        return bookDao.findById(id);
    }

    public void read() {
        bookDao.read();
    }

    public BookService() {
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
