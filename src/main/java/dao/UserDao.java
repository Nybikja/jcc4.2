package dao;

import models.User;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class UserDao {

//    //@PersistenceContext
//    private EntityManager entityManager = new LocalContainerEntityManagerFactoryBean()
//            .getNativeEntityManagerFactory()
//            .createEntityManager();

    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public void save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(user);
    }

    public UserDao() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}