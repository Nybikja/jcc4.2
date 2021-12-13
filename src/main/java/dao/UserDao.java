package dao;

import models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDao() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }

    //    {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setPersistenceXmlLocation("classpath:/META-INF/persistence.xml");
//        entityManagerFactory.setPersistenceUnitName("xxx");
//        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//    }
}
