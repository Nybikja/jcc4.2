package com.company.jcc.repository;

import com.company.jcc.model.Rent;
import com.company.jcc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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

    @Transactional
    public User readById(int id) {
        Query query = entityManager.createQuery("from User where id = " + id);
        return (User) query.getSingleResult();
    }

    @Transactional
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(readById(id));
    }

    public User findByEmail(String email) {
        Query query = entityManager.createQuery("from User where username = " + "'" + email + "'");
        return (User) query.getSingleResult();
    }

//    @Transactional
//    public List<User> findUsersNotReturnedInTime(){
//        TypedQuery<Rent> query = entityManager.createQuery("select distinct User from Rent where timeReturned > timeShouldBeReturned or timeReturned = null and timeShouldBeReturned > current_date", Rent.class);
//        return query.getResultList();
//    }

}
