package com.company.jcc.repository;

import com.company.jcc.model.Rent;
import com.company.jcc.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
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
    public Rent readById(int id) {
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
        entityManager.remove(readById(id));
    }

    @Transactional
    public Rent update(Rent rent){
        return entityManager.merge(rent);
    }

    @Transactional
    public Rent getMostPopular(LocalDate start, LocalDate end){
        Query query = entityManager.createQuery("from Rent where timeTaken between " + "'" + start + "'" + " and " + "'" + end + "'" + " group by book.bookTitle order by count(book.bookTitle) DESC");
        return (Rent) query.setMaxResults(1).getSingleResult();
    }

    @Transactional
    public Rent getMostUnPopular(LocalDate start, LocalDate end){
        Query query = entityManager.createQuery("from Rent where timeTaken between " + "'" + start + "'" + " and " + "'" + end + "'" + " group by book.bookTitle order by count(book.bookTitle) ASC");
        return (Rent) query.setMaxResults(1).getSingleResult();
    }
}
