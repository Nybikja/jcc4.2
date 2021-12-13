package service;

import dao.RoleDao;
import models.Role;

public class RoleService {
    private RoleDao roleDao = new RoleDao();

    public void save(String roleName){
        roleDao.save(new Role(roleName));
    }

    public void read() {
        roleDao.read();
    }

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public RoleService() {
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
