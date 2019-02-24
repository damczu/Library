package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "AUT_Id")
    private int id;
    @Column(name = "AUT_FirstName")
    private String firstName;
    @Column(name = "AUT_LastName")
    private String lastName;
    @ManyToMany
    @JoinTable(name = "AuthorsBooks",
            joinColumns = {@JoinColumn(name = "AUB_AutId", referencedColumnName = "AUT_Id")},
            inverseJoinColumns = {@JoinColumn(name = "AUB_BokId", referencedColumnName = "BOK_Id")}
    )
    List<Book> books;
}
