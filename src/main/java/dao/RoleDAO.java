package dao;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
//@Data
public class RoleDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<UserDAO> users = new ArrayList<>();

    public RoleDAO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDAO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDAO> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
