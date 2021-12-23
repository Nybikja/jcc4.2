package com.company.jcc.repository;

import com.company.jcc.model.Book;
import com.company.jcc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    public User findById(int id) {
        Query query = entityManager.createQuery("from User where id = " + id);
        return (User) query.getSingleResult();
    }

    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    public User findByEmail(String email) {
        return null;
    }

}
