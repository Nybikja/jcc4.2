package com.company.jcc.repository;

import com.company.jcc.model.Rent;
import com.company.jcc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Rent create(Rent rent) {
        entityManager.persist(rent);
        return rent;
    }

    @Transactional
    public Rent findById(int id) {
        Query query = entityManager.createQuery("from Rent where id = " + id);
        return (Rent) query.getSingleResult();
    }

    @Transactional
    public List<Rent> findAll() {
        TypedQuery<Rent> query = entityManager.createQuery("from Rent", Rent.class);
        return query.getResultList();
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

}
