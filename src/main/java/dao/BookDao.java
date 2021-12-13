package dao;

import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class BookDao {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xxx");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    public void save(Book book){
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public void read() {
        entityManager.getTransaction().begin();
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);
        List<Book> list = query.getResultList();
        System.out.println(list);
        entityManager.getTransaction().commit();
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
