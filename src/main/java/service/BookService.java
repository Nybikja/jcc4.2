package service;

import dao.BookDao;
import models.Book;

public class BookService {

    private BookDao bookDao;

    public void save(String bookTitle, int amountLeft, int amountGave, int rating){
        //if (!bookTitle.isEmpty() && amountLeft >= 0 && amountGave >= 0){
            bookDao.save(new Book(bookTitle, amountLeft, amountGave, rating));
        //}
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
