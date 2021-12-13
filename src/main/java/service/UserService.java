package service;

import dao.UserDao;
import models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;

public class UserService {

    private UserDao userDao;


    public void save(String name, String surname, int age, Date sqlDate, String email, String password){
        if (!name.isEmpty() && !surname.isEmpty() && age > 0 && sqlDate.equals(Date.class) && !email.isEmpty() && !password.isEmpty()){
            userDao.save(new User(name, surname, age, sqlDate, email, password));
        }
    }
    public UserService() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
