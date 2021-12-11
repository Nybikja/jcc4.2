package dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class RoleDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
