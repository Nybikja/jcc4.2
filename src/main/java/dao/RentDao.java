package dao;

import models.Rent;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public class RentDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xxx");;
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public RentDao() {
    }

    public void save(Rent rent) {
        entityManager.getTransaction().begin();
        entityManager.persist(rent);
        entityManager.getTransaction().commit();
    }

//    @Transactional
//    void update(Date date, int rentId) {
//        entityManager.createQuery("update Rent set time_returned = " + date + " where id = "
//                + rentId).executeUpdate();
//        Rent rent = findById(rentId);
//        entityManager.persist(rent);
//        entityManager.getTransaction().commit();
//    }
//
//    public void setTimeReturned(int rentId) {
//        Date date = new Date(20101012);
//        findById(rentId).setTimeReturned(date);
//        update(date, rentId);
//    }

    public void findRequestsByUserId(int userId) {
        TypedQuery<Rent> query = entityManager.createQuery("from Rent where user_id = " + userId, Rent.class);
        List<Rent> list = query.getResultList();
        System.out.println(list);
    }

    public Rent findById(int id) {
        Rent rent = entityManager.createQuery("from Rent where id = " + id, Rent.class).getSingleResult();
        System.out.println(rent);
        return rent;
    }

    public void read() {
        TypedQuery<Rent> query = entityManager.createQuery("from Rent", Rent.class);
        List<Rent> list = query.getResultList();
        System.out.println(list);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
