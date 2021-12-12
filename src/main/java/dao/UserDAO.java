package dao;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
@Entity
@Table(name = "user")
//@Data
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Age")
    private int age;

    @Basic
    @Column(name = "date_registered")
    private java.sql.Date sqlDate;

    @Column
    private String email;

    @Column
    private String password;

//    @Column(name = "role_id")
//    int roleId;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private RoleDAO role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RequestDAO> request = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<RentDAO> rent = new ArrayList<>();

    public UserDAO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDAO getRole() {
        return role;
    }

    public void setRole(RoleDAO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sqlDate=" + sqlDate +
                ", email='" + email + '\'' +
                '}';
    }


}
