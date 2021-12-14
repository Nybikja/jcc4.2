package dao;

import models.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoleDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xxx");;;
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public RoleDao() {
    }

    public void save(Role role) {
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();
    }

    public Role findById(int id) {
        System.out.println("Find role by id");
        Role role = entityManager.createQuery("from Role where id = " + id, Role.class).getSingleResult();
        System.out.println(role);
        return role;
    }

    public void read() {
        System.out.println("Get all roles");
        TypedQuery<Role> query = entityManager.createQuery("from Role", Role.class);
        List<Role> list = query.getResultList();
        System.out.println(list);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
