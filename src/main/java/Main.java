import models.Request;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("classpath:/context.xml");

        BookService bookBean = container.getBean(BookService.class);
        UserService userBean = container.getBean(UserService.class);
        RentService rentBean = container.getBean(RentService.class);
        RoleService roleBean = container.getBean(RoleService.class);

        //bookBean.save("Misto", 10, 0, 0);


        Date date = new Date(20101012);
        //userBean.save("petya", "kok", 19, date, "koko@gmail.com", "123456", 1);

//        rentBean.save(5, 6, new Date(20101012), new Date(20104012));

//        rentBean.setTimeReturned(6);

        bookBean.read();

        userBean.read();

        roleBean.read();

        rentBean.read();
        rentBean.findRentByBookId(2);
        rentBean.findRentByUserId(2);
        rentBean.findRentByIds(1, 2);

//        AuthorService authorBean = container.getBean(AuthorService.class);
//        authorBean.setAuthorToBook(3, 2);
//        authorBean.findByIds(3 ,2);


//        manager.close();
//        factory.close();
    }
}