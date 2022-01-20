package com.company.jcc.repository;

import com.company.jcc.model.AuthorName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorNameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(AuthorName authorName) {
        entityManager.persist(authorName);
    }

    @Transactional
    public List<AuthorName> getAll(){
        TypedQuery<AuthorName> query = entityManager.createQuery("from AuthorName", AuthorName.class);
        return query.getResultList();
    }

    @Transactional
    public AuthorName readById(int id) {
        Query query = entityManager.createQuery("from AuthorName where author.id = " + id);
        return (AuthorName) query.getSingleResult();
    }

    @Transactional
    public List<AuthorName> readByAuthor(String surname) {
        Query query = entityManager.createQuery("from AuthorName " +
                "where author.authorSurname = " + "'" + surname + "'");
        return query.getResultList();
    }

    @Transactional
    public AuthorName update(AuthorName authorName) {
        return entityManager.merge(authorName);
    }

    @Transactional
    public void delete(int id) {
        Query query =  entityManager.createQuery("delete from AuthorName where id = " + id);
        entityManager.remove(readById(id));
    }

    public AuthorNameRepository() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
