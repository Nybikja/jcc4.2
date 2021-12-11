package dao;

import javax.persistence.*;
import java.sql.Date;
import lombok.*;
@Entity
@Table(name = "user")
@Data
public class UserDAO {

    public UserDAO() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    private int age;

    @Basic
    @Column(name = "date_registered")
    private java.sql.Date sqlDate;

    private String email;

    private String password;

    @Column(name = "role_id")
    int roleId;
}
