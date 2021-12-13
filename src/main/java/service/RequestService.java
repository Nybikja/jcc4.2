package service;

import dao.RequestDao;
import models.Book;
import models.Request;
import models.User;

import java.util.Date;

public class RequestService {

    private RequestDao requestDao;

    public void save(Date date, User user, Book book){
    }

    public RequestService() {
    }

    public RequestDao getRequestDao() {
        return requestDao;
    }

    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }
}
