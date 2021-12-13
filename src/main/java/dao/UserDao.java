package dao;

import models.Role;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xxx");;
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public UserDao() {
    }

    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public User findById(int id) {
        User user = entityManager.createQuery("from User where id = " + id, User.class).getSingleResult();
        System.out.println(user);
        return user;
    }

    public void read() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        System.out.println(list);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}