package service;

import models.Book;
import models.Request;
import models.User;

import java.util.Date;

public class RequestService {

    private Request request;

//    public void save(Date date, User user, Book book){
//
//    }

    public RequestService() {
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
