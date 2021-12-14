import models.Request;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;
import service.RentService;
import service.UserService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("classpath:/context.xml");
        BookService bookBean = container.getBean(BookService.class);
//        bookBean.save("Misto", 10, 0, 0);

        UserService userBean = container.getBean(UserService.class);
        Date date = new Date(20101012);
//        userBean.save("petya", "kok", 19, date, "koko@gmail.com", "123456", 1);

        RentService rentBean = container.getBean(RentService.class);
//        rentBean.save(5, 6, new Date(20101012), new Date(20104012));
        rentBean.findRentByIds(5, 6);
//        rentBean.setTimeReturned(6);

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
//        EntityManager manager = factory.createEntityManager();
//        manager.getTransaction().begin();


//        TypedQuery<DAO> query = manager.createQuery("select u.book from BookDAO u ", RequestDAO.class);
//        List<RequestDAO> list = query.getResultList();

//        TypedQuery<RoleDAO> query = manager.createQuery("select u.role from UserDAO u ", RoleDAO.class);
//        List<RoleDAO> list = query.getResultList();

//        TypedQuery<UserDAO> query = manager.createQuery("select u from RequestDAO u join fetch u.book where u.id = 8", UserDAO.class);
//        List<UserDAO> list = query.getResultList();

//        TypedQuery<Request> query = manager.createQuery("select u from RequestDAO u join u.book", Request.class);
//        List<Request> list = query.getResultList();
//
//
//        System.out.println(list);
//        manager.getTransaction().commit();
//
//        manager.close();
//        factory.close();
    }
}