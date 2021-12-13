package service;

import models.Request;

public class RequestService {

    private Request request;

    public RequestService() {
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
