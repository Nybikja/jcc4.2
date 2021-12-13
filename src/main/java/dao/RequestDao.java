package dao;

import models.Request;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RequestDao {
    private EntityManagerFactory entityManagerFactory;

    public void save(Request request) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(request);
        entityManager.getTransaction().commit();
    }
}
