import dao.*;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();


//        TypedQuery<DAO> query = manager.createQuery("select u.book from BookDAO u ", RequestDAO.class);
//        List<RequestDAO> list = query.getResultList();

//        TypedQuery<RoleDAO> query = manager.createQuery("select u.role from UserDAO u ", RoleDAO.class);
//        List<RoleDAO> list = query.getResultList();

//        TypedQuery<UserDAO> query = manager.createQuery("select u from RequestDAO u join fetch u.book where u.id = 8", UserDAO.class);
//        List<UserDAO> list = query.getResultList();

        TypedQuery<RequestDAO> query = manager.createQuery("select u from RequestDAO u join u.book", RequestDAO.class);
        List<RequestDAO> list = query.getResultList();

        System.out.println(list);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}
