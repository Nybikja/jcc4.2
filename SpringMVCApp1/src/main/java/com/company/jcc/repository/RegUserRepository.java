package com.company.jcc.repository;

import com.company.jcc.model.RegUser;
import com.company.jcc.model.Rent;
import com.company.jcc.model.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class RegUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public RegUser findByUserName(String username) {
        Query query = entityManager.createQuery("select username, password from RegUser where username = " + "'" + username + "'");
//        System.out.println(query.);
        return (RegUser) query.getSingleResult();
    }


    @Transactional
    public void create(RegUser regUser) {
        entityManager.persist(regUser);
    }
}
