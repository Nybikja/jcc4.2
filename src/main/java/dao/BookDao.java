package dao;

import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class BookDao {

    public BookDao() {
    }

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xxx");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    public void save(Book book){
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public Book findById(int id) {
        System.out.println("Find book by id");
        Book book = entityManager.createQuery("from Book where id = " + id, Book.class).getSingleResult();
        System.out.println(book);
        return book;
    }

    public void read() {
        System.out.println("Get all books");
        entityManager.getTransaction().begin();
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);
        List<Book> list = query.getResultList();
        System.out.println(list);
        entityManager.getTransaction().commit();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
