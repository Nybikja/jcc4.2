package service;

import dao.UserDao;
import models.Role;
import models.User;

import java.sql.Date;

public class UserService {

    private UserDao userDao = new UserDao();
    private final RoleService roleService = new RoleService();

    public void save(String name, String surname, int age, Date sqlDate, String email, String password,int roleId){
        Role role = roleService.findById(roleId);
        userDao.save(new User(name, surname, age, sqlDate, email, password, role));
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public void read() {
        userDao.read();
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
