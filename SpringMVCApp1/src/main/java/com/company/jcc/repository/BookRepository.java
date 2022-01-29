package com.company.jcc.repository;

import com.company.jcc.model.Book;
import com.company.jcc.service.BookService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Transactional
    public List<Book> getAll(){
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);
        return query.getResultList();
    }

    @Transactional
    public Book readById(int id) {
        Query query = entityManager.createQuery("from Book where id = " + id);
        return (Book) query.getSingleResult();
    }

    @Transactional
    public Book readByTitle(String title) {
        Query query = entityManager.createQuery("from Book where bookTitle = " + "'" + title + "'");
        return (Book) query.getSingleResult();
    }

    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Transactional
    public void delete(int id) {
        Query query =  entityManager.createQuery("delete from Book where id = " + id);
        entityManager.remove(readById(id));
    }

    @Transactional
    public void rentBook(int id){
        Query query = entityManager.createQuery("update Book \n" +
                " set amountLeft = amountLeft - 1, amountGave = amountGave + 1\n where id = " + id);
//        query.setParameter("amountLeft", book.getAmountLeft() - 1);
//        query.setParameter("amountGave", book.getAmountGave() + 1);
        query.executeUpdate();
    }
    public BookRepository() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
