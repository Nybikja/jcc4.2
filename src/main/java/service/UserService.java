package service;

import dao.RoleDao;
import dao.UserDao;
import models.Role;
import models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;

public class UserService {

    private UserDao userDao;
    private RoleDao roleDao = new RoleDao();

    public void save(String name, String surname, int age, Date sqlDate, String email, String password,int roleId){
        Role role = roleDao.findById(roleId);
        userDao.save(new User(name, surname, age, sqlDate, email, password, role));
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
