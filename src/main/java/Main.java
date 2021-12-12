import dao.AuthorDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        TypedQuery<AuthorDAO> query = manager.createQuery("select a from AuthorDAO a", AuthorDAO.class);
        List<AuthorDAO> list = query.getResultList();
        System.out.println(list);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
