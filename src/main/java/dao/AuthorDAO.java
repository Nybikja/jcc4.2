package dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
public class AuthorDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author_name;
    private String author_surname;

    @Column(name = "coauthor_exists")
    private boolean coAuthorExists;

}
