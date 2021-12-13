package service;

import dao.BookDao;
import dao.RoleDao;
import models.Book;
import models.Role;

public class RoleService {
    private RoleDao roleDao;

//    public void save(String roleName){
//        roleDao.save(new Role(roleName));
//    }

    public void read() {
        roleDao.read();
    }

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public RoleService() {
    }

//    public BookDao getBookDao() {
//        return bookDao;
//    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
