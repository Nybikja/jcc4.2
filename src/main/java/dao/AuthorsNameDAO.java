package dao;


import javax.persistence.*;

@Entity
@Table(name = "authors_name")
public class AuthorsNameDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    }
