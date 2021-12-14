package service;

import dao.RentDao;
import models.Book;
import models.Rent;
import models.User;


import java.sql.Date;


public class RentService {
    private RentDao rentDao = new RentDao();
    private final UserService userService = new UserService();
    private final BookService bookService = new BookService();

    public RentService() {
    }

    public void save(int userId, int bookId, Date timeTaken, Date timeShouldBeReturned){
        User user = userService.findById(userId);
        Book book = bookService.findById(bookId);
        rentDao.save((new Rent(user, book, timeTaken, timeShouldBeReturned)));
    }

    public void findRentByIds(int userId, int bookId) { rentDao.findRentByIds(userId, bookId); }

    public void setTimeReturned(int rentId) {
        rentDao.setTimeReturned(rentId);
    }

    public void findRequestsByUserId(int userId) { rentDao.findRequestsByUserId(userId); }

    public void findRequestsByBookId(int bookId) {
        rentDao.findRequestsByBookId(bookId);
    }

    public void read() {
        rentDao.read();
    }

    public RentDao getRentDao() {
        return rentDao;
    }

    public void setRentDao(RentDao rentDao) {
        this.rentDao = rentDao;
    }
}
