import dao.*;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();


//        TypedQuery<RequestDAO> query = manager.createQuery("select u.book from BookDAO u ", RequestDAO.class);
//        List<RequestDAO> list = query.getResultList();

        TypedQuery<RoleDAO> query = manager.createQuery("select u.role from UserDAO u ", RoleDAO.class);
        List<RoleDAO> list = query.getResultList();


        System.out.println(list);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
