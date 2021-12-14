package dao;

import models.Author;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDao {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("xxx");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public AuthorDao() {
    }

    public void save(Author author){
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
    }

    public void setAuthorToBook(int bookId, int authorId) {
        entityManager.createQuery("insert into author_book values(" + bookId + "," + authorId + ")");
    }

    public void findByIds(int bookId, int authorId) {
        TypedQuery<Author> query = entityManager.createQuery("from author where author_id = " + authorId
                        + "and book_id = " + bookId, Author.class);
        List<Author> list = query.getResultList();
        System.out.println(list);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
    }
}
