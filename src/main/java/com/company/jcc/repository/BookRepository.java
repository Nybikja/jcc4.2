package com.company.jcc.repository;

import com.company.jcc.model.Book;
import com.company.jcc.service.BookService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Book book) {
        entityManager.persist(book);
    }

    @Transactional
    public List<Book> getAll(){
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);
        return query.getResultList();
    }

    @Transactional
    public Book readById(int id){
        Book book = entityManager.createQuery("from Book where id = " + id, Book.class).getSingleResult();
        return book;
    }

//    @Override
//    public Book readById(int id) {
//        return null;
//    }
//
//    @Override
//    public Book update(Book book) {
//        return null;
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return null;
//    }

    public BookRepository() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
