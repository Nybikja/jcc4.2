import dao.*;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();


        TypedQuery<RequestDAO> query = manager.createQuery("select u from RequestDAO u", RequestDAO.class);
        List<RequestDAO> list = query.getResultList();
        System.out.println(list);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
