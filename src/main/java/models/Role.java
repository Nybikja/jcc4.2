package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
//@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "id_role")
//    private int idRole;

    @Column(name = "Name")
    private String name;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //@JoinColumn(name = "id_role")
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

//    public int getRoleId() {
//        return idRole;
//    }
//
//    public void setRoleId(int roleId) {
//        this.idRole = roleId;
//    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
              //  ", roleId=" + idRole +
                ", name='" + name + '\'' +
                '}';
    }
}
