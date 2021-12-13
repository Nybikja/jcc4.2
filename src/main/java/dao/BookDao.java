package dao;

import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book){
        entityManager.persist(book);
    }

    public BookDao() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
