package dao;

import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BookDao {

    private EntityManagerFactory entityManagerFactory;

    public void save(Book book){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(book);
    }

    public BookDao() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
